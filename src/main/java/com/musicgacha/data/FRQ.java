package com.social_credit_farming.data;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FRQ {
    private String name;
    private String gist;
    private String output;
    public FRQ(String name, String gist, String output) {
        this.name = name;
        this.gist = gist;
        this.output = output;
    }

    public String getName() {
        return name;
    }
    public String getGist() {
        return gist;
    }
    public String getOutput() {
        return output;
    }
}
