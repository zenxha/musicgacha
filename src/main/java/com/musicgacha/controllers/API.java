package com.musicgacha.controllers;
import com.musicgacha.data.Chae;
import com.musicgacha.data.Roll;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
public class API {
//    private ScoreSqlRepository repository;
    @Autowired
    Chae chae = new Chae();
    public API() throws Exception {
    }

    @GetMapping("/api/random/{rarity}")
    public ResponseEntity<Roll> character(@PathVariable("rarity") String rarity) throws IOException, ParseException {
        //String web_server = "http://localhost:8080/";
        return new ResponseEntity<>(chae.getRandom(rarity), HttpStatus.OK);
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
