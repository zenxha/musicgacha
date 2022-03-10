package com.musicgacha.controllers.weeklyFRQs;

import org.apache.commons.lang3.RandomStringUtils;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestParam;



import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;

@Controller  // HTTP requests are handled as a controller, using the @Controller annotation
public class Unit4 {
    @GetMapping("/cb/unit4")
    // CONTROLLER handles GET request for /greeting, maps it to greeting() and does variable bindings
    public String insert(
            @RequestParam(name = "characters", required = false, defaultValue = "0") String characters,
            @RequestParam(name = "numbers", required = false, defaultValue = "false") String numbers,
            @RequestParam(name = "letters", required = false, defaultValue = "false") String letters,
            @RequestParam(name = "amount", required = false, defaultValue = "1") String amount,
            Model model) {
        // @RequestParam handles required and default values, name and model are class variables, model looking like JSON
        int count = Integer.parseInt(characters);
        int amt = Integer.parseInt(amount);
        boolean digits = Boolean.parseBoolean(numbers);
        boolean alphabet = Boolean.parseBoolean(letters);

        ArrayList<String> pswd = new ArrayList<String>();
        for(int i=0; i<amt; i++) {
            String result = RandomStringUtils.random(count, alphabet, digits);
            pswd.add(result);
        }

        String passwords = String.join(", ", pswd);

        model.addAttribute("passwords", passwords); // MODEL is passed to html
        model.addAttribute("codeurl", "https://gist.github.com/zenxha/59845f9b97062aa5ad8ea23b4a3dd8f6.js");


        return "minilabs/passwords"; // returns HTML VIEW (greeting)
    }
}



