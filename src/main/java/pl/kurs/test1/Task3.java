package pl.kurs.test1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] differentWordsArray = new String[10];
        int x = 0;

        System.out.println("Enter 10 different words");
        while (x < 10) {
            System.out.println("Enter word" + (x + 1) + ":");
            String inscription = scanner.nextLine();
            if (inscription.trim().isEmpty()) {
                System.out.println("Word can not be empty");
            } else if (Arrays.asList(differentWordsArray).contains(inscription)) {
                System.out.println("The words must be different");
            } else {
                differentWordsArray[x++] = inscription;
            }
        }

        scanner.close();

        showTheLongestInscriptionAndCountCharactersNumber(differentWordsArray);
        showTheShortestInscriptionAndCountCharactersNumber(differentWordsArray);
        showHowManyPalindromesAreInArray(differentWordsArray);

    }

    static void showTheLongestInscriptionAndCountCharactersNumber(String[] array) {
        ArrayList<String> longestWordsList = new ArrayList<>();
        int maxLength = 0;
        for (String longestWord : array) {
            if (longestWord.length() > maxLength) {
                maxLength = longestWord.length();
                longestWordsList.clear();
                longestWordsList.add(longestWord);
            } else if (longestWord.length() == maxLength) {
                longestWordsList.add(longestWord);
            }
        }
        System.out.print("The longest word/words: ");
        for (String word : longestWordsList) {
            System.out.print(" " + word + " | ");
        }
        System.out.println();
    }

    static void showTheShortestInscriptionAndCountCharactersNumber(String[] array) {
        ArrayList<String> shortestWordsList = new ArrayList<>();
        int minLength = array[0].length();
        for (String shortestWord : array) {
            if (shortestWord.length() < minLength) {
                minLength = shortestWord.length();
                shortestWordsList.clear();
                shortestWordsList.add(shortestWord);
            } else if (shortestWord.length() == minLength) {
                shortestWordsList.add(shortestWord);
            }
        }
        System.out.print("The shortest word/words: ");
        for (String word : shortestWordsList) {
            System.out.print(" " + word + " | ");
        }
        System.out.println();
    }

    static void showHowManyPalindromesAreInArray(String[] array) {
        int palindromesCounter = 0;
        for (String word : array) {
            if (isPalindrome(word))
                ++palindromesCounter;
        }
        System.out.println("Number of palindromes: " + palindromesCounter);
    }

    static boolean isPalindrome(String word) {
        word = word.replaceAll("\\s+", "").toLowerCase();
        int forward = 0;
        int backward = word.length() - 1;

        while (backward > forward) {
            if (word.charAt(forward++) != word.charAt(backward--))
                return false;
        }
        return true;
    }
}
