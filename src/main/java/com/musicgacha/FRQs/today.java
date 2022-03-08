package com.social_credit_farming.FRQs;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;
public class today {
    // Write a Class Number
    public static class Number {
        // instance variables
        private int numberOfSquirrels;
        private int index;
        // Number has a zero Argument constructor
        // It initializes a random number between 3 and 36, ie the number of squirrels in class
        public Number() {
            // constructor
            Random r = new Random();
            numberOfSquirrels = r.nextInt((36-3)+1)+ 3;
        }

        // It contains a getter for the Random Number
        public Integer getNumberOfSquirrels() {
            return numberOfSquirrels;
        }
        public void setIndex(int a) {
            index = a;
        }
        // It contains a getter for Index, or the order it was initialized
        public Integer getIndex() {
            return index;
        }

        // Write a tester method
        public static void main(String[] args) {

            // Create an ArrayList of Type Number, my ArrayList is called squirrels
            ArrayList<Number> squirrels = new ArrayList<Number>();

            // Initialize 10 squirrels of class type Number
            int squirrelNumber = 10;

            // Insert Number instance into ArrayList Squirrel in least to greatest order by random number, mine required nested loops
            for(int i = 0; i<squirrelNumber;i++) {
                Number n = new Number();
                n.setIndex(i);
                squirrels.add(n);
            }

            Collections.sort(squirrels, (n1, n2) -> n1.getNumberOfSquirrels().compareTo(n2.getNumberOfSquirrels()));


            // Print a formatted message with number of Squirrels and Index by which they were created, use enhanced for loop
//            for(int i = 0; i<squirrels.size(); i++) {
//                Number current = squirrels.get(i);
//                System.out.println("Original index: "+ current.getIndex()+"\n"+"Sorted Index: "+ i+"\n\n");
//            }
            for(Number x: squirrels) {
                System.out.println("Number:"+ x.getNumberOfSquirrels()+"\n"+"Old Index: "+x.getIndex()+"\n\n");
            }
        }

    }
}
