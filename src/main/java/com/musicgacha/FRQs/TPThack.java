package com.social_credit_farming.FRQs;

public class TPThack {
    public static void longestStreak(String str) {
        int longestCount = 0;
        char longestChar = 'a';
        int longestCharIndexStart = 2;
        int longestCharIndexEnd = 5;

        int currentCount = 1;
        char currentChar;

        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i + 1) == str.charAt(i)) {
                currentChar = str.charAt(i + 1);
                currentCount++;
                if (longestCount < currentCount) {
                    longestCount++;
                    longestChar = currentChar;
                }
            }
            else {
                currentCount = 1;
            }
        }
        System.out.printf("%c %d %d %d\n", longestChar, longestCount, longestCharIndexStart, longestCharIndexEnd);
    }

    public static void main(String[] args) {
        longestStreak("CCAAAAATTT");
    }
}
