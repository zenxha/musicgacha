package com.social_credit_farming.controllers;

import java.util.Random;
import java.util.ArrayList;

public class CalebKimTest {
    int squirrels;
    int index;
    static int count = 0;

    public CalebKimTest() {
        Random random = new Random();
        //sets the min at 3 max at 36
        squirrels = random.nextInt(34)+3;
        count++;
        index = count;
    }
    public int getSquirrels() {
        return this.squirrels;
    }
    public int getIndex() {
        return this.index;

    }
    public static void main(String[] args) {
        ArrayList<CalebKimTest> squirrels = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            squirrels.add(new CalebKimTest());
        }
        //sort
        for (int j = 0; j < 10; j++) {
            for (int k = 0; k < 10; k++) {
                if (squirrels.get(j).getSquirrels() < squirrels.get(k).getSquirrels()) {
                    CalebKimTest temp = squirrels.get(j);
                    squirrels.set(j, squirrels.get(k));
                    squirrels.set(k, temp);
                }
            }
        }
        // output with squirrel count and # of days
        for (int l = 0; l < 10; l++) {
            System.out.println("Squirrels: " + squirrels.get(l).getSquirrels() + " Day: " + squirrels.get(l).getIndex());
        }

    }

}

