package com.example.medtimeapp;

import java.io.Serializable;

public class Familiar implements Serializable {
    private String name;
    private String phone;

    public Familiar(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }
}
