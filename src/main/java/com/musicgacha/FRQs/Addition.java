package com.social_credit_farming.FRQs;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Addition {
    Scanner scanner = new Scanner(System.in);

    public int getInput(String prompt) {
        boolean integerCheck = false;
        int n = 0;
        while (!integerCheck) {
            try {
                System.out.print(prompt);
                n = scanner.nextInt();
                integerCheck = true;
            } catch (InputMismatchException e) {
                System.out.println("Please enter an integer value.");
                scanner.next();
            }
        }
        return n;
    }

    public void addNumbers () {
        int n1 = getInput("First number: ");
        int n2 = getInput("Second Number: ");
        System.out.println("The sum of " + n1 + " and " + n2 + " is " + (n1 + n2));
    }
    public static void main(String[] args) {
        Addition add = new Addition();
        add.addNumbers();
    }
}