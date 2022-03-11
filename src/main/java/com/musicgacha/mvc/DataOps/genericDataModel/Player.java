package com.musicgacha.mvc.DataOps.genericDataModel;


/*
 * Animal class extends Generics and defines abstract methods
 */
public class Player extends Generics {
    // Class data
    public static KeyTypes key = KeyType.title;  // static initializer
    public static void setOrder(KeyType key) { Player.key = key; }
    public enum KeyType implements KeyTypes {title, name, score, color}

    // Instance data
    private final String name;
    private final int score;

    /* constructor
     *
     */
    public Player(String name, int score)
    {
        super.setType("Player");
        this.name = name;
        this.score = score;
    }

    /* 'Generics' requires getKey to help enforce KeyTypes usage */
    @Override
    protected KeyTypes getKey() { return Player.key; }

    /* 'Generics' requires toString override
     * toString provides data based off of Static Key setting
     */
    @Override
    public String toString()
    {
        String output="";
        if (KeyType.name.equals(this.getKey())) {
            output += this.name;
        } else if (KeyType.score.equals(this.getKey())) {
            output += "00" + this.score;
            output = output.substring(output.length() - 2);
        } else {
            output += super.getType() + ": " + this.name + ", " + this.score;
        }
        return output;

    }

    // Test data initializer
    public static Player[] playerData() {
        return new Player[]{
                new Player("Allen", 60),
                new Player("Tanmay", 44),
                new Player("Komay", 16),
                new Player("Roop", 32),
                new Player("Nick", 99),
                new Player("Mort", 20)
        };
    }

    /* main to test Animal class
     *
     */
    public static void main(String[] args)
    {
        // Inheritance Hierarchy
        Player[] objs = playerData();

        // print with title
        Player.setOrder(KeyType.title);
        Generics.print(objs);

        // print name only
        Player.setOrder(KeyType.name);
        Generics.print(objs);
    }

}
