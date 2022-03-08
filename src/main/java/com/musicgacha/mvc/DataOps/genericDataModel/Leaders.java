package com.social_credit_farming.mvc.DataOps.genericDataModel;


public class Leaders extends Generics {
    // Class data
    public static KeyTypes key = KeyType.title;  // static initializer
    public static void setOrder(KeyType key) {
        Leaders.key = key;}
    public enum KeyType implements KeyTypes {title, leader, year}

    // Instance data
    private final String leader;
    private final int year;

    // Constructor
    Leaders(String leader, int year)
    {
        this.setType("Leaders");
        this.leader = leader;
        this.year = year;
    }

    /* 'Generics' requires getKey to help enforce KeyTypes usage */
    @Override
    protected KeyTypes getKey() { return Leaders.key; }

    /* 'Generics' requires toString override
     * toString provides data based off of Static Key setting
     */
    @Override
    public String toString() {
        String output="";
        if (KeyType.title.equals(this.getKey())) {
            output += this.leader;
        } else if (KeyType.year.equals(this.getKey())) {
            output += this.year;
        } else {
            output = super.getType() + ": " + this.leader + ", " + this.year;
        }
        return output;
    }

    // Test data initializer
    public static Leaders[] cupCakeData() {
        return new Leaders[]{
                new Leaders("Donald Trump", 1946),
                new Leaders("Kim Jong Un", 1982),
                new Leaders("Joe Biden", 1942),
                new Leaders("Mao Zedong", 1893),
                new Leaders("Xi Jiping", 1953),
                new Leaders("Zhong Xina", 1977)
        };
    }

    public static void main(String[] args)
    {
        // Inheritance Hierarchy
        Leaders[] objs = cupCakeData();

        // print with title
        Leaders.setOrder(KeyType.title);
        Generics.print(objs);

        // print flavor only
        Leaders.setOrder(KeyType.leader);
        Generics.print(objs);
    }

}

