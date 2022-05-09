package com.musicgacha.data;

import lombok.Getter;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
@Getter
public class Roll {
    private String image;
    private String name;
    private String origin;
    private String description;

    public Roll(String rarity) throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(new FileReader("src/main/resources/static/json/characters/epic.json"));

        JSONObject jsonObject = (JSONObject) obj;
        JSONArray arr = (JSONArray) jsonObject.get("array");
        JSONObject Roll = (JSONObject)arr.get((int) Math.floor(Math.random() * arr.size()));

        this.image = (String)Roll.get("image");
        this.name = (String)Roll.get("name");
        this.origin = (String)Roll.get("origin");
        this.description = (String)Roll.get("description");
    }
    public String getImage() {
        return image;
    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public String getOrigin() { return origin;}
}
