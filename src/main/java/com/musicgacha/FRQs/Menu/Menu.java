package com.musicgacha.FRQs.Menu;

import java.util.ArrayList;
import com.musicgacha.FRQs.Menu.Option;
import com.musicgacha.FRQs.Menu.Options.IntByReference;
import com.musicgacha.FRQs.Menu.Options.Matrix;

public class Menu {
    public static void Main(String[] args) {
        ArrayList<Option> Options = new ArrayList<>();
        Options.add(new Matrix(null));
        Options.add(new IntByReference(null));
        for(int i=0; i<Options.size();i++ ) {
            System.out.println(Integer.toString(i) + Options.get(i).getClass());
        }
//      Options.forEach( (n) -> { System.out.println("hi"); } ); // passing lambda as a parameter
    }
}
