package com.example.login;

public class Information {

    private String number;
    private String name;

    public Information(String number, String name) {
        this.number = number;
        this.name = name;
    }

    public Information() {
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
