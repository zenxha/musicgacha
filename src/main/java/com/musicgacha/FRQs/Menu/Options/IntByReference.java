package com.musicgacha.FRQs.Menu.Options;


import com.musicgacha.FRQs.Menu.Option;

public class IntByReference implements Option {
    private int value;

    @Override
    public String getTitle() {
        return "IntByReference";
    }

    // Hack: create IntByReference, swapToLowHighOrder and toString methods
    // IntByReference
    public IntByReference(Integer value) {
        this.value = value;
    }

    // toString method
    public String toString() {
        return (String.format("%d", this.value));
    }
    // swapToLowHighOrder
    public void swapToLowHighOrder(IntByReference i) {
        if (this.value > i.value) {
            int temp = this.value;
            this.value = i.value;
            i.value = temp;
        }
    }

    public static void swapper(int n0, int n1) {
        IntByReference a = new IntByReference(n0);
        IntByReference b = new IntByReference(n1);
        System.out.println("Before: " + a + " " + b);
        a.swapToLowHighOrder(b);  // conditionally build swap method to change values of a, b
        System.out.println("After: " + a + " " + b);
        System.out.println();
    }

    public void run() {
        IntByReference.swapper(21, 16);
        IntByReference.swapper(16, 21);
        IntByReference.swapper(16, -1);
    }

}

