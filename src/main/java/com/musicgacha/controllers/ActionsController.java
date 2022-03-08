package com.social_credit_farming.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.HashMap;

@Controller  // HTTP requests are handled as a controller, using the @Controller annotation
public class ActionsController {

    @GetMapping("/actions")
    // CONTROLLER handles GET request for /greeting, maps it to greeting() and does variable bindings
    public String order(@RequestParam(name = "action", required = false, defaultValue = "") String action,
                        Model model) {

        int score = 0;
        String[] words = action.split(" ");
        HashMap<String, String> wordList = new HashMap<String, String>();

        // Add keys and values (Good, Bad)
        wordList.put("idol", "Winnie");
        wordList.put("supreme", "Taiwan");
        wordList.put("Lao", "Tiananmen");
        wordList.put("Xina", "Square");
        wordList.put("Ping", "massacre");
        wordList.put("social", "Muslim");
        wordList.put("study", "3");
        wordList.put("A+", "camps");
        wordList.put("school", "games");
        wordList.put("peace", "war");


        for (String i : wordList.keySet()) {
            if(Arrays.asList(words).contains(i)){
                score += 1;
            }
        }
        for (String k : wordList.values()) {
            if(Arrays.asList(words).contains(k)){
                score -= 1;
            }
        }



        model.addAttribute("score", Integer.toString(score)); // MODEL is passed to html
        model.addAttribute("codeurl", "https://gist.github.com/zenxha/4d44b3fa7e29b7108adbea650cb590f8.js");
;

        return "homesite/action";
    }
}