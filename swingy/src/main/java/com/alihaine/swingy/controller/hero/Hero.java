package com.alihaine.swingy.controller.hero;

import com.alihaine.swingy.controller.GameLoop;

import javax.swing.*;

public class Hero {
    private final String name;
    private final String champ;
    private int level;
    private int experience;
    private int attack;
    private int defense;
    private int hitPoint;
    private final JLabel image;

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

    public int getLevel() {
        return this.level;
    }

    public JLabel getImage() {
        return this.image;
    }

    public String getName() {
        return name;
    }

    public String getChamp() {
        return champ;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public void addExperience(int experience) {
        this.setExperience(this.getExperience() + experience);
        if (this.IsLevelUp())
            this.LevelUp();
        GameLoop.gameLoop.getViewMode().DisplayPlayerInfos(this);
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getHitPoint() {
        return hitPoint;
    }

    public void setHitPoint(int hitPoint) {
        this.hitPoint = hitPoint;
    }
}
