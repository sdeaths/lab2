package com.example.lab2.data.models;

public class LoginAdministrator {

    private final String name;

    private final String key;

    public LoginAdministrator(String name, String key) {
        this.name = name;
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public String getKey() {
        return key;
    }
}
