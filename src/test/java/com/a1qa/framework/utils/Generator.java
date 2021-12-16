package com.a1qa.framework.utils;

import java.util.Random;

public class Generator {
    private static final int BOUND = 8;
    private static final int SHIFT = 3;
    private static final int ALPHABET = 26;
    private static final int MAX_NUMBER = 100;

    public static String textGenerate(int numberOfWords) {
        String[] randomStrings = new String[numberOfWords];
        Random random = new Random();
        for (int i = 0; i < numberOfWords; i++) {
            char[] word = new char[random.nextInt(BOUND) + SHIFT];
            for (int j = 0; j < word.length; j++) {
                word[j] = (char) ('a' + random.nextInt(ALPHABET));
            }
            randomStrings[i] = new String(word);
        }
        return String.join(" ", randomStrings);
    }

    public static int numberGenerate() {
        Random random = new Random();
        return random.nextInt(MAX_NUMBER);
    }
}
