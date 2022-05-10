package com.musicgacha.controllers;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.musicgacha.data.Song;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

@RestController
public class API {
    @Autowired
//    private ScoreSqlRepository repository;
    @GetMapping("/api/random")
    public ResponseEntity<Song> song() throws IOException, ParseException {
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
        System.out.println(displaySong.getTrackName() +" By "+ displaySong.getArtist() +"\nSpotify Link: "+ displaySong.getSpotifyUrl() + "\nYT Link: "+ displaySong.getYoutubeUrl()+"\n\n");
        return new ResponseEntity<Song>(displaySong, HttpStatus.OK);

    }
//    @PostMapping("/api/pushscore")
//    public ResponseEntity<Score> saveScore(
//            @RequestParam(value = "username", required = false) String username,
//            @RequestParam(value = "score", required = false) String newscore,
//            Model model)
//    {
//        Score score = new Score(username, Long.parseLong(newscore));
//        System.out.println("New score update\n"+ "Username: "+score.getUsername()+"\nPoints: "+score.getScore());
//        //repository.save(score);
////        return new ResponseEntity<String>("{\"username\": "+"\""+username+"\","+ "oldScore\": \"0\",\"newScore\":"+newscore+"\""+" }", HttpStatus.OK);
//        return new ResponseEntity<Score>(score, HttpStatus.OK);
//    }
}
