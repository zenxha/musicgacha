package com.musicgacha.controllers.weeklyFRQs;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;

@Controller  // HTTP requests are handled as a controller, using the @Controller annotation
public class Unit2 {
    @GetMapping("/cb/unit2")
    // CONTROLLER handles GET request for /greeting, maps it to greeting() and does variable bindings
    public String insert(@RequestParam(name = "value", required = false, defaultValue = "0") String value,
                         @RequestParam(name = "index", required = false, defaultValue = "0") String index,
                         @RequestParam(name = "replace", required = false, defaultValue = "0 1 0 1 0 1 0 1 0 1 0 1") String replace,
                         @RequestParam(name = "name1", required = false, defaultValue = "0") String name1,
                         @RequestParam(name = "name2", required = false, defaultValue = "0") String name2,
                         Model model) {
        // @RequestParam handles required and default values, name and model are class variables, model looking like JSON
        int[] intArr
                = new int[]{0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1};
        String original = Arrays.toString(intArr);

        int[] arr = method(replace);

        String replaced = Arrays.toString(arr);

        int a = Integer.parseInt(value);
        int b = Integer.parseInt(index);

        for (int i = arr.length - 1; i > b; i--) {
            arr[i] = arr[i - 1];
        }
        arr[b] = a;
        String newlist = Arrays.toString(arr);

        int x = Integer.parseInt(name1);
        int y = Integer.parseInt(name2);
        double c = Math.sqrt(x*x + y*y);
        String s = String.valueOf(c);

        model.addAttribute("s", s); // MODEL is passed to html
        model.addAttribute("codeurl", "https://gist.github.com/zenxha/71d626080aaa6773c2b735db5e5ae73c.js");
        model.addAttribute("original", original); // MODEL is passed to html
        model.addAttribute("newlist", newlist);
        model.addAttribute("replaced", replaced);

        return "minilabs/insertion"; // returns HTML VIEW (greeting)
    }

    private int[] method(String replace) {
        String[] splitArray = replace.split(" ");
        int[] array = new int[splitArray.length];

        // parsing the String argument as a signed decimal
        // integer object and storing that integer into the
        // array
        for (int i = 0; i < splitArray.length; i++) {
            array[i] = Integer.parseInt(splitArray[i]);
        }
        return array;
    }
}
