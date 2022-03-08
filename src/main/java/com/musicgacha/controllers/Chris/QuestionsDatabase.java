package com.social_credit_farming.controllers.Chris;

import java.util.ArrayList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class QuestionsDatabase {
    public ArrayList<Question> que = new ArrayList<>();
    public Question cq;
    public String qtext;
    public String chinese_qtext;
    public int cqnumber;
    public String key;


    public QuestionsDatabase() {
        key = "AIzaSyCfFqRDFCd301gjkhxG_pPAERMdZoKrTfg";
        qtext = "...waiting for action...";

        String q0 = "An old lady crosses the street and you ignore her and keep playing clash of clans [-50]";
        que.add(new Question(q0, -50, 0));

        String q1 = "You got home from school really late because you stopped by the river to throw rocks. You tell your mom that your late because you kept studying [-50]";
        que.add(new Question(q1, -50, 1));

        String q2 = "You are working on a test and then the bell rings, but you have not finished yet. You continue working for 30 seconds and then submit [-100]";
        que.add(new Question(q2, -100, 2));

        String q3 = "You are walking in the hall and trip a girl passing [-150]";
        que.add(new Question(q3, -150, 3));

        String q4 = "You missed rent payment [-100]";
        que.add(new Question(q4, -100, 4));

        String q5 = "You lost a family heirloom [-50]";
        que.add(new Question(q5, -50, 5));

        String q6 = "You pushed faulty code into Git  [-50]";
        que.add(new Question(q6, -50, 6));

        String q7 = "You forgot long division [-50]";
        que.add(new Question(q7, -50, 7));

        String q8 = "You dragged your team down during the AP US History group chapter check [-100]";
        que.add(new Question(q8, -100, 8));

        String q9 = "You forgot the first index in a list is zero [-50]";
        que.add(new Question(q9, -50, 9));

        String q10 = "You saw an old lady crossing the street so you quit your clash royale game to go help her [+150]";
        que.add(new Question(q10, 150, 10));

        String q11 = "Your got home really late because you stopped by the river to throw rocks. When you get home you tell your mom the truth [+50]";
        que.add(new Question(q11, 50, 11));

        String q12 = "You are working on a test and then the bell rings. You submit even though you are not yet finished [+50]";
        que.add(new Question(q12, 50, 12));

        String q13 = "You are walking in the hallway and give a random person a compliment [+100]";
        que.add(new Question(q13, 100, 13));

        String q14 = "You clutched on your rent payment [+100]";
        que.add(new Question(q14, 100, 14));

        String q15 = "You found a family heirloom thought lost in a drawer [+50]";
        que.add(new Question(q15, 50, 15));

        String q16 = "You committed working code [+50]";
        que.add(new Question(q16, 50, 16));

        String q17 = "You remembered redox reactions in chemistry +100";
        que.add(new Question(q17, 100, 17));

        String q18 = "You carried your team during the AP US History chapter check [+100]";
        que.add(new Question(q18, 100, 18));

        String q19 = "you remembered the first index in a list is zero [+50]";
        que.add(new Question(q19, 50, 19));

    }

    public void getQuestion() throws IOException {
        int qnumber = (int) (((double)Math.random() * (double)100.0)/(double)5.0);

        if(qnumber > que.size()-1) {
            qnumber = que.size()-1;
        }

        cqnumber = qnumber;
        cq = que.get(qnumber);
        qtext = cq.text;
    }

}
