package ru.rambler.jiratasksupdater.git;


import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.errors.IncorrectObjectTypeException;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.revwalk.RevWalk;
import org.eclipse.jgit.storage.file.FileRepositoryBuilder;
import org.gradle.api.logging.Logger;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ru.rambler.jiratasksupdater.Utils;

public class GitDataProvider {
    private String currentBranch;
    private Repository existingRepo;
    private Logger logger;
    private Pattern smartCommitPattern;
    private Date lastTagDate;

    public GitDataProvider() {

    }

    public void init(String jiraProjectId, String branch, Logger logger) throws IOException {
        // Open an existing repository
        existingRepo = new FileRepositoryBuilder()
                .setGitDir(new File(".git"))
                .build();

        this.currentBranch = branch;
        this.logger = logger;
        this.smartCommitPattern = Pattern.compile(".*(" + jiraProjectId + "-" + "/d*).*");
    }

    public List<String> getJiraTasks() throws GitException, IOException, GitAPIException {
        if (existingRepo == null || Utils.stringIsEmpty(currentBranch)) {
            throw new GitException("Provider is not inited");
        }

        Git git = new Git(existingRepo);

        List<Ref> refs = git.tagList().call();

        RevWalk rw = new RevWalk(existingRepo);

        for (Ref ref : refs) {
            try {
                Date d = rw.parseTag(ref.getObjectId()).getTaggerIdent().getWhen();

                if (lastTagDate == null || d.after(lastTagDate)) {
                    lastTagDate = d;
                }
            } catch (IncorrectObjectTypeException e) {
                Date d = rw.parseCommit(ref.getObjectId()).getCommitterIdent().getWhen();
                if (lastTagDate == null || d.after(lastTagDate)) {
                    lastTagDate = d;
                }
            }
        }

        return parseCommits(git.log().call());
    }

    private List<String> parseCommits(Iterable<RevCommit> revCommitList) {
        List<String> commits = new ArrayList<>();

        for (RevCommit revCommit : revCommitList) {

            String shortMessage = revCommit.getShortMessage();

            if (!revCommit.getAuthorIdent().getWhen().after(lastTagDate)) {
                continue;
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
