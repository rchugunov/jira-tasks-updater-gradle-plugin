package ru.rambler.jiratasksupdater.git;


import org.gradle.api.tasks.StopActionException;

public class GitException extends StopActionException {
    public GitException() {
    }

    public GitException(String message) {
        super(message);
    }
}
