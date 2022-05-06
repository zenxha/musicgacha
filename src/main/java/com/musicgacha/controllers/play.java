package com.musicgacha.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller  // HTTP requests are handled as a controller, using the @Controller annotation
public class play {
    @GetMapping("/play")
    // CONTROLLER handles GET request for /greeting, maps it to greeting() and does variable bindings
    public String play() {
        return "homesite/play"; // returns HTML VIEW (greeting)
    }
}