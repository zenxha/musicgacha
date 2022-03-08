package com.social_credit_farming.FRQs;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CreditCard {
    public static void checkCard () {
        Scanner scanner = new Scanner(System.in);
        boolean integerCheck = false;
        long card = 0;

        // Ask user for credit card number, re-prompt if non-integer string is input
        while (!integerCheck) {
            try {
                System.out.print("Enter a valid credit card number: ");
                card = scanner.nextLong();
                integerCheck = true;
            } catch (InputMismatchException e) {
                System.out.println("Please enter an integer value.");
                System.out.println();
                scanner.next();
            }
        }
        // TODO: allow dashes in between numbers

        // Reject negative/zero input
        if (card <= 0) {
            System.out.println("INVALID");
            return;
        }

        // Luhn's Algorithm
        String cardString = String.valueOf(card);
        int sum = 0;
        int cardlength = cardString.length();
        int digit;
        for (int i = 0; i < cardlength - 1; i += 2) {
            digit = Character.getNumericValue(cardString.charAt(cardlength - i - 2));
            if (2 * digit > 9) {
                sum += (2 * digit - 9);
            }
            else {
                sum += (2 * digit);
            }
        }

        for (int j = 0; j < cardlength; j += 2) {
            sum += Character.getNumericValue(cardString.charAt(cardlength - j - 1));
        }

        // Determine and print type of card
        int fdigit = Character.getNumericValue(cardString.charAt(0));
        int sdigit = Character.getNumericValue(cardString.charAt(1));

        if (sum % 10 == 0) {
            if ((cardlength == 13 || cardlength == 16) && fdigit == 4) {
                System.out.println("VISA");
            }
            else if (cardlength == 15 && fdigit == 3 && (sdigit == 4 || sdigit == 7)) {
                System.out.println("AMEX");
            }
            else if (cardlength == 16 && fdigit == 5 && (sdigit == 1 || sdigit == 2 || sdigit == 3 || sdigit == 4 || sdigit == 5)) {
                System.out.println("MASTERCARD");
            }
            else {
                System.out.println("INVALID");
            }
        }
        else {
            System.out.println("INVALID");
        }
    }

    // Main method
    public static void main(String[] args) {
        checkCard();
    }
}
