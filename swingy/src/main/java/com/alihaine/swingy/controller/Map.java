package com.alihaine.swingy.controller;

import com.alihaine.swingy.controller.hero.Hero;

import java.util.LinkedList;

public class Map {

    private final LinkedList<String> map = new LinkedList<>();

    public Map() {
        final int mapSize = this.MapSizeCalculator();
        GameLoop.gameLoop.getViewMode().DisplayMap(mapSize);
    }


    private int MapSizeCalculator() {
        final Hero hero = GameLoop.gameLoop.getCurrentHero();
        return (hero.getLevel()-1) * 5 + 10 - (hero.getLevel()%2);
    }
}
