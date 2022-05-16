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
public class Roll {
    private String image;
    private String name;
    private String origin;
    private String description;
    private String rarity, key;
    public Roll(JSONObject r, String rarity)  {
        this.rarity = rarity;
        image = (String)r.get("image");
        name = (String)r.get("name");
        origin = (String)r.get("origin");
        description = (String)r.get("description");
        key = (String)r.get("key");
    }
    public String getImage() {
        return image;
    }
    public String getName() { return name; }
    public String getDescription() {
        return description;
    }
    public String getOrigin() { return origin;}
    public String getRarity() { return rarity;}
    public String getKey() { return key;}
}
