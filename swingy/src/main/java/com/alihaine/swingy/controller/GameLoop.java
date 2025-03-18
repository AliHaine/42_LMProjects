package com.alihaine.swingy.controller;

import com.alihaine.swingy.controller.hero.Hero;
import com.alihaine.swingy.controller.hero.heros.Fizz;
import com.alihaine.swingy.view.ViewMode;
import com.alihaine.swingy.view.gui.Gui;

public class GameLoop {

    public static final GameLoop gameLoop = new GameLoop();
    private GameLoop() {}

    private Hero hero;
    private ViewMode viewMode;
    private Map map;

    public void LaunchGame(String gameViewMode) {
        if (gameViewMode.equals("gui"))
            this.viewMode = new Gui();
        this.map = new Map(4);
        this.hero = new Fizz("Test");
        this.viewMode.DisplayToPosition(this.map.getCurrentMapSize() * 64 / 2 - 32, this.map.getCurrentMapSize() * 64 / 2 - 32, this.hero.getImage());

        /*while(1 != 2) {

        }*/
    }

    public void GenerateNewMap() {
        this.map = new Map(this.hero.getLevel());
        this.viewMode.DisplayToPosition(this.map.getCurrentMapSize() * 64 / 2 - 32, this.map.getCurrentMapSize() * 64 / 2 - 32, this.hero.getImage());
    }

    public Hero getCurrentHero() {
        return this.hero;
    }

    public ViewMode getViewMode() {
        return this.viewMode;
    }

    public Map getCurrentMap() {
        return this.map;
    }

}
