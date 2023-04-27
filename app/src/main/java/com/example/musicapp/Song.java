package com.example.musicapp;

import com.google.firebase.database.Exclude;

public class Song {
    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getSongUrl() {
        return songUrl;
    }

    public void setSongUrl(String songUrl) {
        this.songUrl = songUrl;
    }

    public String songName;
    public String songUrl;


}
