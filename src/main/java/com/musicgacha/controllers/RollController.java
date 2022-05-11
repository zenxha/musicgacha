package com.musicgacha.controllers;
import com.musicgacha.data.RandomRoll;
import com.musicgacha.data.Roll;
import com.musicgacha.data.Song;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Controller;
import com.musicgacha.data.Song;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

@Controller
public class RollController {

    @GetMapping("/roll")
    public String song(Model model) throws IOException, ParseException {
        //String web_server = "http://localhost:8080/";


        String rarity = "";
        int number = (int) Math.floor(Math.random() * 10000);
        if(number > 3000) {rarity = "common";}
        else if(number >1000) {rarity = "uncommon";}
        else if(number > 200) {rarity = "epic";}
        else if(number > 1) {rarity = "legendary";}
        else {rarity = "mythical";}
//        rarity = "epic";
        RandomRoll c = new RandomRoll(rarity);
        model.addAttribute("character", c);
        System.out.println(c.getName());
        System.out.println(c.getOrigin());
        System.out.println(c.getDescription()+"\n");
        return "homesite/roll";

    }


    @GetMapping("/play")
    // CONTROLLER handles GET request for /greeting, maps it to greeting() and does variable bindings
    public String play() {
        return "homesite/play"; // returns HTML VIEW (greeting)
    }


    @GetMapping("/all")
    public String all(Model model) throws IOException, ParseException {
        //String web_server = "http://localhost:8080/";
        Map<String, ArrayList<Roll>> database = new HashMap<String, ArrayList<Roll>>();
        String[] rarities = {"common", "uncommon", "epic", "legendary"};
        for(String x : rarities) {
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader("src/main/resources/static/json/characters/"+x+".json"));
            ArrayList<Roll> cock = new ArrayList<>();
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray arr = (JSONArray) jsonObject.get("array");
            for(Object y: arr) {

                Roll roll = new Roll((JSONObject)y, x );

                cock.add(roll);
            }
            database.put(x, cock);
        }
        model.addAttribute("database", database);
        return "homesite/all";

    }
}