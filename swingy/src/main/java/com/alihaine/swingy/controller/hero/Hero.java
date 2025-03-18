package com.alihaine.swingy.controller.hero;

import javax.swing.*;

public class Hero {
    private final String name;
    private final String champ;
    private int level;
    private int experience;
    private int attack;
    private int defense;
    private int hitPoint;
    private JLabel image;

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

    protected boolean IsLevelUp() {
        return this.experience >= this.LevelCalculator();
    }

    protected void LevelUp() {
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
}
