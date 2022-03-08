package com.social_credit_farming.FRQs;

// Unit 5 FRQ Question #2

public class PasswordGenerator {
    String prefix;
    int length;
    int pwcount;

    // Overloaded constructor
    public PasswordGenerator (String p, int n) {
        prefix = p;
        length = n;
    }

    // Default (no prefix) constructor
    public PasswordGenerator (int n) {
        prefix = "A";
        length = n;
    }

    public int pwCount () {
        return pwcount;
    }
}