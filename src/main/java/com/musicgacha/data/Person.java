package com.musicgacha.data;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Person {
    private String name;
    private String info;
    private String maskOff;
    private String maskOn;
    public Person(String name, String info, String maskoff, String maskon) {
        this.name = name;
        this.info = info;
        this.maskOff = maskoff;
        this.maskOn = maskon;
    }
    public String getName() {
        return name;
    }
    public String getInfo() {
        return info;
    }
    public String getMaskOff() {
        return maskOff;
    }
    public String getMaskOn() {
        return maskOn;
    }
}
