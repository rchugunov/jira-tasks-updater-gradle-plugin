package ru.rambler.jiratasksupdater.git;


import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.errors.MissingObjectException;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.storage.file.FileRepositoryBuilder;
import org.gradle.api.logging.Logger;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GitDataProvider {
    private Repository existingRepo;
    private Logger logger;
    private Pattern smartCommitPattern;

    public GitDataProvider() {

    }

    public void init(String jiraProjectId, Logger logger) throws IOException {
        // Open an existing repository
        existingRepo = new FileRepositoryBuilder()
                .setGitDir(new File(".git"))
                .build();

        logger.quiet("Current branch " + existingRepo.getBranch());
        this.logger = logger;
        this.smartCommitPattern = Pattern.compile(".*(" + jiraProjectId + "-\\d*).*");
    }

    public Set<String> getJiraTasks(boolean findSecondTag) throws GitException, IOException, GitAPIException {
        if (existingRepo == null) {
            throw new GitException("Provider is not inited");
        }

        Git git = new Git(existingRepo);
        return parseCommits(git, git.log().call(), findSecondTag);
    }

    private Set<String> parseCommits(Git git, Iterable<RevCommit> revCommitList, boolean findSecondTag) {
        Set<String> commits = new LinkedHashSet<>();

        int tagsFound = 0;

        for (RevCommit revCommit : revCommitList) {
            String shortMessage = revCommit.getShortMessage();
            logger.quiet("Commit " + shortMessage + "       " + revCommit.getName() + "    Second tag: " + findSecondTag);

            try {
                Map<ObjectId, String> tags = git.nameRev().addPrefix("refs/tags/").add(revCommit).call();

                if (!tags.isEmpty()) {

                    boolean newTagFound = false;

                    for (Map.Entry<ObjectId, String> entry : tags.entrySet()) {
                        if (!entry.getValue().contains("~")) {
                            newTagFound = true;
                            tagsFound += 1;
                            break;
                        }
                        logger.quiet("Found tag " + entry.getValue() + " for commit " + shortMessage);
                    }

                    if (newTagFound && (!findSecondTag || tagsFound >= 2)) {
                        break;
                    }
                }
            } catch (MissingObjectException | GitAPIException e) {
                logger.error(e.getMessage(), e);
            }

            if (shortMessage.matches(smartCommitPattern.pattern())) {
                Matcher smCommitMatcher = smartCommitPattern.matcher(shortMessage);
                while (smCommitMatcher.find()) {
                    String commit = smCommitMatcher.group(1);
                    commits.add(commit);
                }
            }
        }

        return commits;
    }
}
