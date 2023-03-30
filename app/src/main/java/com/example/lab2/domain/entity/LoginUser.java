package com.example.lab2.domain.entity;

public class LoginUser {

    private final String phone;

    private final String password;

    public LoginUser(String phone, String password) {
        this.phone = phone;
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public String getPassword() {
        return password;
    }
}
