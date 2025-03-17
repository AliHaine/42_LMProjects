package com.alihaine.swingy.controller;

import com.alihaine.swingy.controller.hero.Hero;
import com.alihaine.swingy.controller.hero.heros.Fizz;
import com.alihaine.swingy.view.ViewMode;
import com.alihaine.swingy.view.gui.Gui;

public class GameLoop {

    private Hero hero = new Fizz("test");

    public static final GameLoop gameLoop = new GameLoop();
    private ViewMode viewMode;
    private Map map;

    private GameLoop() {}

    public void LaunchGame(String gameViewMode) {
        if (gameViewMode.equals("gui"))
            this.viewMode = new Gui();

        this.map = new Map();

        /*while(1 != 2) {

        }*/
    }

    public Hero getCurrentHero() {
        return this.hero;
    }

    public ViewMode getViewMode() {
        return viewMode;
    }
}
