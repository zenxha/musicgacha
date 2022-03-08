package com.social_credit_farming.controllers.Chris;

public class User {
    public String name;
    public int age;
    public int score;
    public String phone_number;
    public int internet_speed;
    public String right_to_travel_outside_country;
    public String can_use_business_class;
    public int highest_hotel_class;
    public String can_attend_top_college;
    public String can_receive_financial_aid;
    public String free_covid_masks;
    public int weeks_of_vacation;
    public String can_go_to_movies;
    public String[] piclinks = new String[5];
    public String ladder;

    public User(String name, int age, int score) {
        this.name = name;
        this.age = age;
        this.score = score;
        this.phone_number = "858-767-0642";

        piclinks[0] = "https://files.catbox.moe/mepdn2.png";
        piclinks[1] = "https://files.catbox.moe/huw0im.png";
        piclinks[2] = "https://files.catbox.moe/lxcckf.png";
        piclinks[3] = "https://files.catbox.moe/kkwun8.png";
        piclinks[4] = "https://files.catbox.moe/jdec5d.png";

        ladder = piclinks[2];

        updateProfile();
    }

    public int getScore() {
        return this.score;
    }

    public void updateScore(int v) {
        this.score = this.score + v;

        if (this.score > 1000) {
            this.score = 1000;
        }

        if (this.score < 0) {
            this.score = 0;
        }

        updateProfile();
    }

    public void updateProfile() {
        if       (this.score >= 0 && this.score <= 250) {
            this.phone_number = "Line disabled";
            this.internet_speed = 100;
            this.right_to_travel_outside_country = "NO";
            this.can_use_business_class = "NO";
            this.highest_hotel_class = 2;
            this.can_attend_top_college = "NO";
            this.can_receive_financial_aid = "NO";
            this.free_covid_masks = "NO";
            this.weeks_of_vacation = 2;
            this.can_go_to_movies = "NO";

            this.ladder = piclinks[0];

        } else if(this.score > 250 && this.score <= 500) {
            this.phone_number = "858-767-0642";
            this.internet_speed = 500;
            this.right_to_travel_outside_country = "YES";
            this.can_use_business_class = "NO";
            this.highest_hotel_class = 3;
            this.can_attend_top_college = "NO";
            this.can_receive_financial_aid = "NO";
            this.free_covid_masks = "YES";
            this.weeks_of_vacation = 3;
            this.can_go_to_movies = "YES";

            this.ladder = piclinks[1];

        } else if(this.score > 500 && this.score <= 750) {
            this.phone_number = "858-767-0642";
            this.internet_speed = 750;
            this.right_to_travel_outside_country = "YES";
            this.can_use_business_class = "NO";
            this.highest_hotel_class = 4;
            this.can_attend_top_college = "NO";
            this.can_receive_financial_aid = "YES";
            this.free_covid_masks = "YES";
            this.weeks_of_vacation = 4;
            this.can_go_to_movies = "YES";

            this.ladder = piclinks[2];

        } else if(this.score > 750 && this.score <= 999) {
            this.phone_number = "858-767-0642";
            this.internet_speed = 1000;
            this.right_to_travel_outside_country = "YES";
            this.can_use_business_class = "YES";
            this.highest_hotel_class = 5;
            this.can_attend_top_college = "YES";
            this.can_receive_financial_aid = "YES";
            this.free_covid_masks = "YES";
            this.weeks_of_vacation = 5;
            this.can_go_to_movies = "YES";

            this.ladder = piclinks[3];

        } else {
            this.phone_number = "858-767-0642";
            this.internet_speed = 1000;
            this.right_to_travel_outside_country = "YES";
            this.can_use_business_class = "YES";
            this.highest_hotel_class = 5;
            this.can_attend_top_college = "YES";
            this.can_receive_financial_aid = "YES";
            this.free_covid_masks = "YES";
            this.weeks_of_vacation = 5;
            this.can_go_to_movies = "YES";

            this.ladder = piclinks[4];
        }

    }
}
