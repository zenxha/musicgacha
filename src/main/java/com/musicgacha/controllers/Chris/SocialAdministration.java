package com.musicgacha.controllers.Chris;

public class SocialAdministration {
    public User u;
    public QuestionsDatabase qdb;

    public SocialAdministration() {
        u = new User("Han Lee", 25, 500);
        qdb = new QuestionsDatabase();
    }
}
