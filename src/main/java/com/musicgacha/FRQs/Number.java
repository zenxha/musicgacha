package com.social_credit_farming.FRQs;

import java.util.Collections;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import java.util.ArrayList;

// Write a Class Number
public class Number {
    static int counter;
    int randomNumber;
    int index;
    // instance variables

    // Number has a zero Argument constructor
    // It initializes a random number between 3 and 36, ie the number of squirrels in class
    public Number() {
        randomNumber = ThreadLocalRandom.current().nextInt(3, 37);
        counter++;
        index = counter;

        // constructor
    }
    public int getRandomNumber (){
        return randomNumber;
    }

    // It contains a getter for the Random Number
    public int getIndex(){
        return index;
    }
    // It contains a getter for Index, or the order it was initialized


    // Write a tester method
    public static void main(String[] args) {
        ArrayList<Number> squirrels = new ArrayList<Number>();

        for (int i = 0; i < 10; i++)
        {
            squirrels.add(new Number());
        }
        /* ArrayList after sorting*/
        ArrayList<Number> sortedSquirrels = new ArrayList<Number>();

        // Insert Number instance into ArrayList Squirrel in least to greatest order by random number, mine required nested loops
        while (squirrels.size() > 0) {
            int minIndex = 0;
            for (int i = 0; i < squirrels.size(); i++) {
                if (squirrels.get(minIndex).getRandomNumber() > squirrels.get(i).getRandomNumber()) {
                    minIndex = i;
                }
            }
            sortedSquirrels.add(squirrels.get(minIndex));
            squirrels.remove(minIndex);
        }
        for (Number n : sortedSquirrels) {
            System.out.println("Squirrel: " + n.getRandomNumber() + " Index: " + n.getIndex());

        }


        // Create an ArrayList of Type Number, my ArrayList is called squirrels

        // Initialize 10 squirrels of class type Number
        // Insert Number instance into ArrayList Squirrel in least to greatest order by random number, mine required nested loops


        // Print a formatted message with number of Squirrels and Index by which they were created, use enhanced for loop

    }

}
