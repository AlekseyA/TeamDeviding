package com.n1.teamdeviding.app;

import android.graphics.drawable.Drawable;

import java.io.Serializable;

/**
 * Created by aleksey on 5/19/14.
 */
public class Player implements Serializable{
    private String name;
    private int skill;
    private int photo;


    public Player(String n, int s){
        name = n;
        skill = s;
        photo = R.drawable.player;
    }

    public Player(String n, int s, int d){
        name = n;
        skill = s;
        photo = d;
    }

    public String getName() { return name; }

    public void setName(String name) {
        this.name = name;
    }

    public int getSkill() {
        return skill;
    }

    public void setSkill(int skill) {
        this.skill = skill;
    }

    public int getPhoto() { return photo; }

    public void setPhoto(int photo) { this.photo = photo; }
}
