package com.social_credit_farming.FRQs;

public class DinnerParty {
    private boolean rsvp;
    private int selection;
    private String option1;
    private String option2;

    // Constructor to initialize instance variables
    public DinnerParty (String attendance, String food) {
        if (attendance.equals("Yes")) {
            rsvp = true;
        }
        if (attendance.equals("No")) {
            rsvp = false;
        }
        if (food.equals("Fish")) {
            selection = 0;
        }
        if (food.equals("Beef")) {
            selection = 1;
        }
        if (food.equals("Chicken")) {
            selection = 2;
        }
        if (food.equals("Pasta")) {
            selection = 3;
        }
    }

    // (a) Write a code segment that prints "attending" if rsvp is true and prints "not attending" otherwise.
    public void checkAttendance() {
        if (rsvp) {
            System.out.println("attending");
        }
        else {
            System.out.println("not attending");
        }
    }

    // (b) Write a code segment that prints the food item associated with selection. For example, if selection is 3, the code segment should print "pasta".
    public String foodOption() {
        if (selection == 1) {
            System.out.println("beef");
            return "beef";
        }
        else if (selection == 2) {
            System.out.println("chicken");
            return "chicken";
        }
        else if (selection == 3) {
            System.out.println("pasta");
            return "pasta";
        }
        else {
            System.out.println("fish");
            return "fish";
        }
    }

    // (c) Write a code segment that will store a dinner selection in option1 based on the values of rsvp and selection...
    public void responseMessage() {
        if (rsvp) {
            option1 = "Thanks for attending. You will be served " + this.foodOption() + ".";
        }
        else {
            option1 = "Sorry you can't make it.";
        }
        System.out.println(option1);
    }

    // (d) Write a code segment that will print true if the strings option1 and option2 contain the same values and will print false otherwise.
    public void compareOptions() {
        System.out.println(option1.equals(option2));
    }

    // Driver code / testing
    public static void main(String[] args) {
        DinnerParty test = new DinnerParty("Yes", "Pasta");
        test.checkAttendance();
        test.foodOption();
        test.responseMessage();
        test.compareOptions();
    }
}