package com.musicgacha.controllers;
/* MVC code that shows defining a simple Model, calling View, and this file serving as Controller
 * Web Content with Spring MVCSpring Example: https://spring.io/guides/gs/serving-web-con
 */

import com.musicgacha.data.Song;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

@Controller  // HTTP requests are handled as a controller, using the @Controller annotation
public class PBLControl {
    @GetMapping("/quiz")
    // CONTROLLER handles GET request for /greeting, maps it to greeting() and does variable bindings
    public String quiz(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {
        // @RequestParam handles required and default values, name and model are class variables, model looking like JSON
        model.addAttribute("name", name); // MODEL is passed to html
        return "homesite/quiz"; // returns HTML VIEW (greeting)

    }

    @GetMapping("/imagemathgame")
    // CONTROLLER handles GET request for /greeting, maps it to greeting() and does variable bindings
    public String imagemathgame() {
        return "homesite/imagemathgame";
    }

    @GetMapping("/shop")
    // CONTROLLER handles GET request for /greeting, maps it to greeting() and does variable bindings
    public String shop(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {
        // @RequestParam handles required and default values, name and model are class variables, model looking like JSON
        model.addAttribute("name", name); // MODEL is passed to html
        return "homesite/shop"; // returns HTML VIEW (greeting)
    }
    @GetMapping("/mvcdemo")
    public String song(Model model) throws IOException, ParseException {
        //String web_server = "http://localhost:8080/";

        ArrayList<Song> lis = new ArrayList<>();


        JSONParser parser = new JSONParser();
        Object obj = parser.parse(new FileReader("src/main/resources/static/json/songs.json"));

        JSONObject jsonObject = (JSONObject) obj;

        for(Iterator iterator = jsonObject.keySet().iterator(); iterator.hasNext();) {
            String key = (String) iterator.next();

            // Song song = new Song();
            JSONObject SongJSON = (JSONObject) jsonObject.get(key);
            lis.add(new Song((String)SongJSON.get("trackTitle"), (String)SongJSON.get("artist"), (String)SongJSON.get("lyrics"), (String)SongJSON.get("spotify"), (String)SongJSON.get("youtube")));

        }

        // Printing song data in console
        Song displaySong = lis.get((int) Math.floor(Math.random() * lis.size()));
        model.addAttribute("song", displaySong);
        return "homesite/song";

    }
}