package com.musicgacha.controllers;
import com.musicgacha.data.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.musicgacha.data.Song;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

@Controller
public class RollController {
    @Autowired
    Chae chae = new Chae();
    public RollController() throws Exception {
    }

    @GetMapping("/roll")
    public String song(Model model, @RequestParam(name="rarity", required = false, defaultValue = "") String r) throws IOException, ParseException {
        //String web_server = "http://localhost:8080/";
        String rarity = "";

        System.out.println(r);
        int number = (int) Math.floor(Math.random() * 10000);
        if(number > 3000) {rarity = "common";}
        else if(number >1000) {rarity = "uncommon";}
        else if(number > 200) {rarity = "epic";}
        else if(number > 1) {rarity = "legendary";}
        else {rarity = "mythical";}
        if(!r.equals("")){rarity = r;}
//        RandomRoll c = new RandomRoll(rarity);

        model.addAttribute("character", chae.getRandom(rarity));
        return "homesite/roll";

    }


    @GetMapping("/all")
    public String all(Model model) throws Exception {
        model.addAttribute("database", chae.queryAll());
        return "homesite/all";
    }

    @GetMapping("/characters/{id}")
    public String character(@PathVariable("id") String id, Model model) {
        model.addAttribute("character", chae.getByID(id));
        return "homesite/character";
    }
}