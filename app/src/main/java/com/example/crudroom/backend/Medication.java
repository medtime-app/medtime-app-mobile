package com.example.medtimeapp;

import java.io.Serializable;

public class Medication implements Serializable {
    private String name;
    private String time;
    private String dose;
    private String type;

    public Medication(String name, String time, String dose, String type) {
        this.name = name;
        this.time = time;
        this.dose = dose;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getTime() {
        return time;
    }

    public String getDose() {
        return dose;
    }

    public String getType() {
        return type;
    }
}
