package org.example;

import java.util.ArrayList;
import java.util.List;

public class Reversion {

    public static final String SPACE = " ";
    private static boolean isContainSpaceOnly(String inputString) {
        String replacedSpaces = inputString.replaceAll(SPACE, "");
        return replacedSpaces.length() == 0;
    }
    public static String splitAndRevers(String inputString) {

        String[] splitArray = inputString.split(SPACE);
        List<String> reversedWords = new ArrayList<>();

        if (inputString.equals("")) {
            throw new IllegalArgumentException("VARIABLE IS EMPTY");
        }

        if (isContainSpaceOnly(inputString)) {
            return inputString;
        }

        for (String word : splitArray) {
            char[] charArray = word.toCharArray();
            String reversedWord = reverseWord(charArray);
            reversedWords.add(reversedWord);
        }

        return String.join(" ", reversedWords);
    }

    public static String reverseWord(char[] charArray) {
        int count = 0;
        char[] letterArray = new char[charArray.length];
        for (char c : charArray) {
            if (c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z') {
                letterArray[count] = c;
                count++;
            }
        }
        reverse(letterArray, count);
        addNonLetter(charArray,letterArray);
        return new String(charArray);
    }

    public static void reverse(char[] charArray, int count) {
        for (int i = 0; i < count / 2; i++) {
            char temporary = charArray[i];
            charArray[i] = charArray[count - 1 - i];
            charArray[count - 1 - i] = temporary;
        }
    }

    public static void addNonLetter(char[] charArray, char[] temporaryArray) {
        int count = 0;
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] >= 'a' && charArray[i] <= 'z' || charArray[i] >= 'A' && charArray[i] <= 'Z') {
                charArray[i] = temporaryArray[count];
                count++;
            }
        }
    }
}

