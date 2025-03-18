package com.alihaine.swingy.controller;

import com.alihaine.swingy.controller.hero.Hero;

public class Map {

    private int currentMapSize;

    public Map(int playerLevel) {
        this.setCurrentMapSize(MapSizeCalculator(playerLevel));
        GameLoop.gameLoop.getViewMode().DisplayMap(this.currentMapSize);
    }

    private int MapSizeCalculator(int playerLevel) {
        return (playerLevel-1) * 5 + 10 - (playerLevel%2);
    }

    public int getCurrentMapSize() {
        return this.currentMapSize;
    }

    public void setCurrentMapSize(int size) {
        this.currentMapSize = size;
    }
}
