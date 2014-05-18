package com.n1.teamdeviding.app;

/**
 * Created by aleksey on 5/19/14.
 */
public class Player {
    private String name;
    private int skill;


    public Player(String n, int s){
        name = n;
        skill = s;
        MainActivity.playersList.add(this);
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
}
