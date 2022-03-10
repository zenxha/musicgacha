package com.musicgacha.FRQs.Menu;

import java.util.ArrayList;
import com.musicgacha.FRQs.Menu.Option;

public class Menu {
    public static void Main(String[] args) {
        ArrayList<Option> Options = new ArrayList<>();

        Options.forEach( (n) -> { System.out.println(n); } ); // passing lambda as a parameter
    }
}
