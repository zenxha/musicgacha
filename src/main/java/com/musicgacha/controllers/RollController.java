package com.musicgacha.controllers;
import com.musicgacha.data.Roll;
import com.musicgacha.data.Song;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Controller;
import com.musicgacha.data.Song;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

@Controller
public class RollController {
    @GetMapping("/roll")
    public String song(Model model) throws IOException, ParseException {
        //String web_server = "http://localhost:8080/";

        Roll c = new Roll("epic");
        model.addAttribute("character", c);
        System.out.println(c.getName());
        System.out.println(c.getOrigin());
        System.out.println(c.getDescription());
        return "homesite/roll";

    }
}