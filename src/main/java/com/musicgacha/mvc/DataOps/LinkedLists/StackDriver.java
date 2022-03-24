package com.musicgacha.mvc.DataOps.LinkedLists;

import com.musicgacha.utility.ConsoleMethods;
import com.musicgacha.mvc.DataOps.genericDataModel.Alphabet;
import com.musicgacha.mvc.DataOps.genericDataModel.Player;
import com.musicgacha.mvc.DataOps.genericDataModel.Leaders;


/**
 * Stack Driver takes a list of Objects and puts them onto the Stack
 * @author johnmortensen
 *
 */
public class StackDriver {

    private Stack stack;
    private String dataType="";
    private int count;

    public StackDriver()
    {
        count = 0;
        stack = new Stack();
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public void pushStack(Object[] objects)
    {
        ConsoleMethods.println("Add " + dataType);
        for (Object o : objects)
        {
            stack.push(o);
            ConsoleMethods.println("Push: " + stack.getObject() + " " + stack);
            this.count++;
        }
        ConsoleMethods.println();

    }

    public void showStack()
    {
        ConsoleMethods.println("Size: " + count);
        ConsoleMethods.println("Top Element: " + stack.getObject());
        ConsoleMethods.println("Full Stack: " + stack);
        ConsoleMethods.println();
    }

    public void popStack()
    {
        ConsoleMethods.println("Delete " + dataType);
        for (int x = 0; x<count; x++)
        {
            ConsoleMethods.println("Pop: " + stack.pop() + " " + stack);
        }
    }

    /*
     * Illustrate different Objects that can be placed on same Stack
     */
    public static void main(String[] args)
    {
        StackDriver trial = new StackDriver();

        // setup for Animals
        trial.setDataType("Players");
        trial.pushStack(Player.playerData());

        // setup for Cupcakes
        trial.setDataType("Cupcakes");
        trial.pushStack(Leaders.cupCakeData());

        // setup for Alphabet
        trial.setDataType("Alphabet");
        trial.pushStack(Alphabet.alphabetData());

        // mixed stack
        trial.setDataType("Alphabet then Cupcakes then Animals");
        trial.showStack();
        trial.popStack();
    }

}