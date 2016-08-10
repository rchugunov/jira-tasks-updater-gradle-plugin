package ru.rambler.jiratasksupdater.git;


import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.revplot.PlotCommit;
import org.eclipse.jgit.revplot.PlotCommitList;
import org.eclipse.jgit.revplot.PlotLane;
import org.eclipse.jgit.revplot.PlotWalk;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.revwalk.RevCommitList;
import org.eclipse.jgit.revwalk.RevWalk;
import org.eclipse.jgit.storage.file.FileRepositoryBuilder;
import org.gradle.api.logging.Logger;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ru.rambler.jiratasksupdater.Utils;

public class GitDataProvider {
    private String currentBranch;
    private Repository existingRepo;
    private Logger logger;
    private Pattern smartCommitPattern;

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

    public List<String> getJiraTasks() throws GitException, IOException {
        if (existingRepo == null || Utils.stringIsEmpty(currentBranch)) {
            throw new GitException("Provider is not inited");
        }

        RevWalk walk = new RevWalk(existingRepo);

        ObjectId from = existingRepo.resolve("refs/heads/" + currentBranch);
        ObjectId to = existingRepo.resolve("refs/remotes/origin/master");
        walk.markStart(walk.parseCommit(from));
        walk.markUninteresting(walk.parseCommit(to));

        RevCommitList<RevCommit> revCommitList = new RevCommitList<RevCommit>();
        revCommitList.source(walk);
        revCommitList.fillTo(walk.parseCommit(to), Integer.MAX_VALUE);

        return parseCommits(revCommitList);
    }

    private List<String> parseCommits(RevCommitList<RevCommit> revCommitList) {
        List<String> commits = new ArrayList<>();
        for (RevCommit revCommit : revCommitList) {
            String fullMessage = revCommit.getFullMessage();

            if (fullMessage.matches(smartCommitPattern.pattern())) {
                Matcher smCommitMatcher = smartCommitPattern.matcher(fullMessage);
                while (smCommitMatcher.find()) {
                    String commit = smCommitMatcher.group(1);
                    commits.add(commit);
                }
            }
        }

        return commits;
    }
}
