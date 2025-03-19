package com.alihaine.swingy.controller;

import com.alihaine.swingy.view.gui.Gui;
import lombok.Getter;
import lombok.Setter;

public class Map {

    @Getter @Setter private int currentMapSize;

    public Map(int playerLevel) {
        this.setCurrentMapSize(MapSizeCalculator(playerLevel));
        GameLoop.gameLoop.getViewMode().DisplayMap(this.currentMapSize);
    }

    private int MapSizeCalculator(int playerLevel) {
        return (playerLevel-1) * 5 + 10 - (playerLevel%2);
    }
}
