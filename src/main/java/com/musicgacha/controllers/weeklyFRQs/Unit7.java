package com.musicgacha.controllers.weeklyFRQs;

import org.apache.catalina.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Arrays;

@Controller  // HTTP requests are handled as a controller, using the @Controller annotation
public class Unit7 {

    public class UserName {
        private ArrayList<String> possibleNames = new ArrayList<String>();
        public UserName(String firstName, String lastName)
        {
            for (int i=1; i<=firstName.length(); i++) {
                String subStr = firstName.substring(0,i);
                possibleNames.add(lastName+subStr);
            }
            System.out.println(String.join(" ",possibleNames ));
        }
        public void setAvailableUserNames(String[] usedNames) {
            for(String x : usedNames) {
                if(possibleNames.contains(x)) {
                    possibleNames.remove(x);
                }
            }
            System.out.println(String.join(" ", possibleNames));
        }
        public String getAvailableUserNames() {
            return String.join(", ", possibleNames);
        }
    }
    @GetMapping("/cb/unit7")
    // un handles GET request for /greeting, maps it to greeting() and does variable bindings
    public String order(@RequestParam(name = "first", required = false, defaultValue = "John") String first,
                        @RequestParam(name = "last", required = false, defaultValue = "Smith") String last,
                        @RequestParam(name = "usednames", required =false, defaultValue = "SmithJo ") String usednames,
                        Model model) {
        model.addAttribute("first", first);
        model.addAttribute("last", last);
        UserName n = new UserName(first, last);
        String[] usedNamesArray = usednames.split(" ");
        n.setAvailableUserNames(usedNamesArray);
        model.addAttribute("usernames", n.getAvailableUserNames());
        model.addAttribute("codeurl", "https://gist.github.com/zenxha/cad5fa3eb65ead6271ff6e3f4e0dadaf.js");

        return "minilabs/unit7";
    }
}


