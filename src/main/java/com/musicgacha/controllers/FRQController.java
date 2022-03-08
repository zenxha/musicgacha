package com.social_credit_farming.controllers;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import com.social_credit_farming.data.FRQ;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.springframework.ui.Model;

@Controller
public class FRQController {
    @GetMapping("/cb")
    public String Frq() {
        return "minilabs/minilabhome";
    }

    @GetMapping("/cb/1")
    public String week1(Model model) throws IOException, ParseException {
        ArrayList<FRQ> lis = new ArrayList<>();


        JSONParser parser = new JSONParser();
        Object obj = parser.parse(new FileReader("src/main/resources/static/json/week1.json"));
        JSONObject jsonObject = (JSONObject) obj;


        for(Iterator iterator = jsonObject.keySet().iterator(); iterator.hasNext();) {
            String key = (String) iterator.next();

            // Song song = new Song();
            JSONObject FRQobj = (JSONObject) jsonObject.get(key);
            lis.add(new FRQ((String)FRQobj.get("name"),(String)FRQobj.get("gist"), (String)FRQobj.get("output")));

        }
        System.out.println(lis.get(0).getName());
        model.addAttribute("FRQlist", lis );
        model.addAttribute("gistSrc", jsonObject);
        return "cb/week1";

    }
    @GetMapping("/cb/all")
    public String Empty() {
        return "minilabs/index";
    }

    @GetMapping("/cb/tmrepl")
    public String Null() {
        return "minilabs/tmrepl";
    }

}