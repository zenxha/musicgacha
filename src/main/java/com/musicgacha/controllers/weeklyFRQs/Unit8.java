package com.social_credit_farming.controllers.weeklyFRQs;

import org.apache.commons.lang3.RandomStringUtils;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
@Controller
public class Unit8 {
    @GetMapping("/cb/unit8")
    public String insert(
            @RequestParam(name = "crop", required = false, defaultValue = "corn") String crop,
            @RequestParam(name = "corn00", required = false, defaultValue = "20") String corn00,
            @RequestParam(name = "corn01", required = false, defaultValue = "30") String corn01,
            @RequestParam(name = "peas02", required = false, defaultValue = "10") String peas02,
            @RequestParam(name = "peas10", required = false, defaultValue = "30") String peas10,
            @RequestParam(name = "corn11", required = false, defaultValue = "40") String corn11,
            @RequestParam(name = "corn12", required = false, defaultValue = "62") String corn12,
            @RequestParam(name = "wheat20", required = false, defaultValue = "10") String wheat20,
            @RequestParam(name = "corn21", required = false, defaultValue = "50") String corn21,
            @RequestParam(name = "rice22", required = false, defaultValue = "30") String rice22,
            @RequestParam(name = "corn30", required = false, defaultValue = "55") String corn30,
            @RequestParam(name = "corn31", required = false, defaultValue = "30") String corn31,
            @RequestParam(name = "peas32", required = false, defaultValue = "30") String peas32,
            Model model) {

        String result = new String();

        if (crop.equalsIgnoreCase("corn")) {
            /*Corn Coordinates*/
            String[] cords = {"Coordinate (0,0)", "Coordinate (0,1)", "Coordinate (1,1)", "Coordinate (1,2)", "Coordinate (2,1)", "Coordinate (3,0)", "Coordinate (3,1)"};
            /*Corn Inputs*/
            String str = corn00 + " " + corn01 + " " + corn11 + " " + corn12 + " " + corn21 + " " + corn30 + " " + corn31;
            String[] numbers = str.split(" ");
            /*Convert Inputs into Integers*/
            int[] ints = new int[numbers.length];
            for (int c = 0; c < numbers.length; c++)
                ints[c] = Integer.parseInt(numbers[c]);
            /*Find largest, return index value*/
            int largest = 0;
            for (int i = 1; i < ints.length; i++) {
                if (ints[i] > ints[largest]) largest = i;
            }
            result = cords[largest];

        }
        if (crop.equalsIgnoreCase("peas")) {
            String[] cords = {"Coordinate (0,2)", "Coordinate (1,0)", "Coordinate (3,2)"};
            String str = peas02 + " " + peas10 + " " + peas32;
            String[] numbers = str.split(" ");

            int[] ints = new int[numbers.length];
            for (int c = 0; c < numbers.length; c++)
                ints[c] = Integer.parseInt(numbers[c]);

            int largest = 0;
            for (int i = 1; i < ints.length; i++) {
                if (ints[i] > ints[largest])
                    largest = i;
            }
            result = cords[largest];

        }
        if (crop.equalsIgnoreCase("rice")) {
            result = rice22;
        }
        if (crop.equalsIgnoreCase("wheat")) {
            result = wheat20;
        }


        model.addAttribute("result", result); // MODEL is passed to html
        model.addAttribute("codeurl", "https://gist.github.com/zenxha/05de69bace78cae682ba6b616aa97212.js");



        return "minilabs/unit8"; // returns HTML VIEW (greeting)
        }

    }



