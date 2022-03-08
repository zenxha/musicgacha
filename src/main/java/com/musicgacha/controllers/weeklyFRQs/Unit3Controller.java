package com.social_credit_farming.controllers.weeklyFRQs;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;

@Controller  // HTTP requests are handled as a controller, using the @Controller annotation
public class Unit3Controller {
    @GetMapping("/cb/canvas")
    public String Canvas(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "minilabs/canvas";
    }
    @GetMapping("/cb/unit3")
    // CONTROLLER handles GET request for /greeting, maps it to greeting() and does variable bindings
    public String order(@RequestParam(name = "rsvp", required = false, defaultValue = "") String rsvp,
                        @RequestParam(name = "value", required = false, defaultValue = " ") String value,
                        @RequestParam(name = "option1", required = false, defaultValue = "Test") String option1,
                        @RequestParam(name = "option2", required = false, defaultValue = "Test") String option2,
                         Model model) {

        boolean bool = Boolean.parseBoolean(rsvp);
        String attending;
        String theFood = "";
        if(bool) {
            attending = "Thanks for attending. You will be served ";
            String[] foods = {"beef.", "chicken.", "pasta.", "fish."};
            int index = Integer.parseInt(value)-1;
            if(index>3) index=3;
            theFood = foods[index];
            model.addAttribute("food", theFood);
        }
        else { attending = "Sorry you can't make it.";}

        boolean option = option1.equals(option2);
        String result = Boolean.toString(option);

        model.addAttribute("result", result);
        model.addAttribute("codeurl", "https://gist.github.com/zenxha/4d44b3fa7e29b7108adbea650cb590f8.js");
        model.addAttribute("attending", attending);
        model.addAttribute("food", theFood);

        return "minilabs/unit3";
    }
    }