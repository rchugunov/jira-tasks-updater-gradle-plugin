package ru.rambler.jiratasksupdater;


import java.util.Base64;

public class Base64Helper {
    public static final String encode(String input) {
        return Base64.getEncoder().encodeToString(input.getBytes());
    }
}
