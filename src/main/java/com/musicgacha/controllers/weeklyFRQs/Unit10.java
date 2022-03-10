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
public class Unit10 {
    @GetMapping("/cb/unit10")
    // CONTROLLER handles GET request for /greeting, maps it to greeting() and does variable bindings
    public String insert(
            @RequestParam(name = "intA", required = false, defaultValue = "0") String intA,
            @RequestParam(name = "intB", required = false, defaultValue = "0") String intB,

            Model model) {

        int num1 = Integer.parseInt(intA);
        int num2 = Integer.parseInt(intB);
        int gcd = 1;

        for(int i = 1; i <= num1 && i <= num2; i++)
        {
            if(num1%i==0 && num2%i==0)
                gcd = i;
        }

        model.addAttribute("GCF", Integer.toString(gcd)); // MODEL is passed to html
        model.addAttribute("codeurl", "https://gist.github.com/zenxha/808227880d925ce557ff84da473a48da.js");



        return "minilabs/unit10"; // returns HTML VIEW (greeting)
    }
}
