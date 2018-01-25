package com.tx2.levelcounter.Models;

import com.tx2.levelcounter.R;

public class Player {
    String name;
    byte sex;
    int  gear, level, photo;

    public Player(String name) {
        this.name = name;
        this.sex = 1;
        this.gear = 0;
        this.level = 1;
        this.photo = R.drawable.player_unknown;
    }

    public Player() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte getSex() {
        return sex;
    }

    public void setSex(byte sex) {
        this.sex = sex;
    }

    public int getGear() {
        return gear;
    }

    public void setGear(int gear) {
        this.gear = gear;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }
}
