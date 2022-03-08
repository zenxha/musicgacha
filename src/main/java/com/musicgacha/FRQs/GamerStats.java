package com.social_credit_farming.FRQs;

public class GamerStats {
    private String username;
    private int killCount;
    private int deathCount;
    private static final String role = "Duelist";

    public String getUsername() {
        return username;
    }
    public int getKills () {
        return killCount;
    }
    public int getDeaths () {
        return deathCount;
    }
    public String getRole () {
        return role;
    }
    public void setUsername(String ign) {
        username = ign;
    }
    public void setKills (int kills) {
        killCount = kills;
    }
    public void setDeaths (int deaths){
        deathCount = deaths;
    }
    public double calculateKDR () {
        return (double) killCount/deathCount;
    }
    public void printStats () {
        System.out.println("Statistics for " + role + " " + username);
        System.out.println(killCount + " Kills");
        System.out.println(deathCount + " Deaths");
        System.out.println("K/D of " + calculateKDR());
    }
    public static void main(String[] args) {
        GamerStats gamer = new GamerStats();
        gamer.setUsername("JohnDoe123");
        gamer.setKills(23471);
        gamer.setDeaths(8418);
        gamer.printStats();
    }
}