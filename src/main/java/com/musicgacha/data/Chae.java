package com.musicgacha.data;

import com.fasterxml.jackson.core.io.JsonEOFException;
import org.codehaus.groovy.tools.shell.IO;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

@Component
public class Chae {
    private Map<String, ArrayList<Roll>> database = new LinkedHashMap<>();
    public Chae() throws Exception {

        String[] rarities = {"common", "uncommon", "epic", "legendary", "mythical"};
        for(String x : rarities) {
            ArrayList<Roll> cock = new ArrayList<>();
            JSONParser parser = new JSONParser();
            JSONArray arr;
            try {
                Object obj = parser.parse(new FileReader("src/main/resources/static/json/characters/"+x+".json"));
                JSONObject jsonObject = (JSONObject) obj;
                arr = (JSONArray) jsonObject.get("array");
            } catch(ParseException e) {
                throw new Exception("oops");
            } catch(IOException e) {
                throw new Exception("oops");
            }

            for(Object y: arr) {
                Roll roll = new Roll((JSONObject)y, x );
                cock.add(roll);
            }
            Collections.shuffle(cock);
            this.database.put(x, cock);

        }

    }
    public void shuffleAll() {
        for(ArrayList<Roll> x : database.values()) {
            Collections.shuffle(x);
        }
    }
    public Roll getRandom(String rarity) {
        ArrayList<Roll> lis = database.get(rarity);
        Roll x = lis.get((int) Math.floor(Math.random() * lis.size()));
        return x;
    }

    public Map queryAll() {
        shuffleAll();
        return database;
    }
    public Roll getByID(String ID) {
        Roll y = null;
        for (Map.Entry<String, ArrayList<Roll>> entry : database.entrySet()) {
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
            for(Roll x : entry.getValue()) {
                if(ID.equals(x.getID())) {
                    y =x;
                }
            }
        }
        return y;
    }

}
