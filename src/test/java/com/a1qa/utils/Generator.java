package com.a1qa.utils;

import java.util.Random;

public class Generator {
    public static String textGenerate(int numberOfWords) {
        String[] randomStrings = new String[numberOfWords];
        Random random = new Random();
        for (int i = 0; i < numberOfWords; i++) {
            char[] word = new char[random.nextInt(8) + 3]; // words of length 3 through 10. (1 and 2 letter words are boring.)
            for (int j = 0; j < word.length; j++) {
                word[j] = (char) ('a' + random.nextInt(26));
            }
            randomStrings[i] = new String(word);
        }
        return String.join(" ", randomStrings);
    }
    public static int numberGenerate(){
        Random random = new Random();
        int generateNumber = random.nextInt(100);
        return generateNumber;
    }
}
