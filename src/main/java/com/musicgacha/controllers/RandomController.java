package com.musicgacha.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.ArrayList;
import java.util.List;

import java.util.Random;


import java.util.Arrays;

@Controller  // HTTP requests are handled as a controller, using the @Controller annotation
public class RandomController {
    @GetMapping("/random")
    // CONTROLLER handles GET request for /greeting, maps it to greeting() and does variable bindings
    public String insert(@RequestParam(name = "rolls", required = false, defaultValue = "0") String rolls,
                         Model model) {

        //prototype array list, just used repeated elements to increase probability of each element
        ArrayList<String> rarity = new ArrayList<String>();
        for (int i = 0; i < 59; i++) {
            rarity.add("Common");
        }
        for (int i = 0; i < 35; i++) {
            rarity.add("Uncommon");
        }
        for (int i = 0; i < 10; i++) {
            rarity.add("Epic");
        }
        rarity.add("Legendary");

        //output list that will be displayed
        ArrayList<String> output = new ArrayList<String>();

        int amount = Integer.parseInt(rolls);

        //randomly select elements from array list, add to output array
        for (int i = 0; i < amount; i++) {
            String selected = getRandomElement(rarity);
            output.add(selected);
        }
        //convert array list to string to display
        String result = String.join(", ", output);


        model.addAttribute("result", result); // MODEL is passed to html

        return "homesite/random"; // returns HTML VIEW (greeting)
    }
    // randomly selects value from an array list
    public String getRandomElement(List<String> list) {
        Random rand = new Random();
        return list.get(rand.nextInt(list.size()));
    }

    //  tester/driver
    public static void main(String[] args) {
        ArrayList<String> rarity = new ArrayList<String>();
        rarity.add("Common");
        rarity.add("Uncommon");
        rarity.add("Epic");
        rarity.add("Legendary");

        RandomController rc = new RandomController();

        ArrayList<String> output = new ArrayList<String>();

        int amount = 5;

        for (int i = 0; i < amount; i++) {
            String selected = rc.getRandomElement(rarity);
            output.add(selected);
            System.out.println(selected);
        }

    }
}


