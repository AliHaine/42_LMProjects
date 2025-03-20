package com.alihaine.swingy.controller.hero;

import com.alihaine.swingy.controller.GameLoop;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;

public class Hero {
    @Getter @Setter private int id;
    @Getter private final String name;
    @Getter private final String champ;
    @Getter private int level;
    @Getter @Setter private int experience;
    @Getter @Setter private int attack;
    @Getter @Setter private int defense;
    @Getter @Setter private int hitPoint;
    @Getter private final JLabel image;
    @Getter private int[] currentPos = new int[2]; //xy
    @Getter private int[] lastPos = new int[2]; //xy

    protected Hero(String name, String champ, JLabel image, int level, int experience, int attack, int defense, int hitPoint) {
        this.name = name;
        this.champ = champ;
        this.level = level;
        this.experience = experience;
        this.attack = attack;
        this.defense = defense;
        this.hitPoint = hitPoint;
        this.image = image;
    }

    public boolean IsLevelUp() {
        return this.experience >= this.LevelCalculator();
    }

    public void LevelUp() {
        this.level++;
        this.experience = 0;
        this.attack++;
        this.defense++;
        this.hitPoint = 100 + 10 * this.level;
    }

    private int LevelCalculator() {
        final int toSquare = this.level-1;
        return this.level * 1000 + (toSquare * toSquare) * 450;
    }

    public void addExperience(int experience) {
        this.setExperience(this.getExperience() + experience);
        if (this.IsLevelUp())
            this.LevelUp();
        GameLoop.gameLoop.getViewMode().DisplayPlayerInfos(this);
    }

    public void setCurrentPos(int x, int y) {
        this.currentPos[0] = x;
        this.currentPos[1] = y;
    }

    public void setLastPos(int x, int y) {
        this.lastPos[0] = x;
        this.lastPos[1] = y;
    }
}
