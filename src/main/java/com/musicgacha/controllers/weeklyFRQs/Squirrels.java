package com.social_credit_farming.controllers.weeklyFRQs;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class Squirrels {
    @GetMapping("/cb/unit10")
    // CONTROLLER handles GET request for /greeting, maps it to greeting() and does variable bindings
    public String insert(
            @RequestParam(name = "intA", required = false, defaultValue = "0") String intA,
            @RequestParam(name = "intB", required = false, defaultValue = "0") String intB,
            Model model) {


        model.addAttribute("codeurl", "https://gist.github.com/zenxha/808227880d925ce557ff84da473a48da.js");



        return "minilabs/unit10"; // returns HTML VIEW (greeting)
    }

}



