package com.social_credit_farming.controllers.weeklyFRQs;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;

@Controller  // HTTP requests are handled as a controller, using the @Controller annotation
public class Unit5 {

    public class Invitation {
        private String hostName;
        private String address;
        public Invitation(String hostName, String address)
        {
            this.hostName = hostName;
            this.address = address;
        }
        public String printInvitation() {
            return("<b>Class name</b>: Invitation<br><b>hostname:</b> "+hostName+"<br><b>Address</b>: "+address);
        }
        public void updateAddress(String newAddress) {
            address = newAddress;
        }
        public String invite(String invitee) {
            return("Dear "+ invitee+" please attend my event at "+ address+". See you then, "+hostName);
        }
    }
    @GetMapping("/cb/unit5")
    // un handles GET request for /greeting, maps it to greeting() and does variable bindings
    public String order(@RequestParam(name = "location", required = false, defaultValue = "") String location,
                        @RequestParam(name = "invitee", required = false, defaultValue = " ") String invitee,
                        Model model) {
        Invitation inv = new Invitation("Komay", location);
        inv.updateAddress(location);
        model.addAttribute("inv", inv);
        model.addAttribute("output", inv.invite(invitee));
        model.addAttribute("codeurl", "https://gist.github.com/zenxha/895e866e8ac011f775e7bb9137e7b0f8.js");

        return "minilabs/unit5";
    }
}