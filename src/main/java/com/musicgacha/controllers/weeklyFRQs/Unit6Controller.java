package com.social_credit_farming.controllers.weeklyFRQs;

import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;

@Controller  // HTTP requests are handled as a controller, using the @Controller annotation
public class Unit6Controller {
    @GetMapping("/cb/unit6")
    // CONTROLLER handles GET request for /greeting, maps it to greeting() and does variable bindings
    public String insert(
            @RequestParam(name = "replace", required = false, defaultValue = "ten fading post card thunder hinge trailing batting") String replace,
            Model model) {
        // @RequestParam handles required and default values, name and model are class variables, model looking like JSON
        String[] strArr
                = new String[]{"ten", "fading", "post", "card", "thunder", "hinge", "trailing", "batting"};
        String original = Arrays.toString(strArr);

        String[] words = replace.split(" ");

        ArrayList<String> ing = new ArrayList<String>();

        for (String word : words) {
            if ((word.substring(word.length() - 3, word.length())).equals("ing")) {
                ing.add(word);
            }
        }
        String replaced = String.join(", ", ing);


        model.addAttribute("original", original); // MODEL is passed to html
        model.addAttribute("replaced", replaced);
        model.addAttribute("codeurl", "https://gist.github.com/zenxha/ce1267e452f38beab466946293310d0c.js");


        return "minilabs/unit6"; // returns HTML VIEW (greeting)
    }
}


