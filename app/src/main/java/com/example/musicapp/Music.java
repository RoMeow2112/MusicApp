package com.example.musicapp;

public class Music {
    private String name;
    private String url;

    public Music() {}

    public Music(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }

    public String geturl() {
        return url;
    }

    public void seturl(String url) {
        this.url = url;
    }
}

