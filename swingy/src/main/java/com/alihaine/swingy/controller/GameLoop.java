package com.alihaine.swingy.controller;

import com.alihaine.swingy.controller.hero.Hero;
import com.alihaine.swingy.controller.hero.heros.Boss;
import com.alihaine.swingy.controller.hero.heros.Fizz;
import com.alihaine.swingy.controller.hero.heros.Shaco;
import com.alihaine.swingy.view.ViewMode;
import com.alihaine.swingy.view.gui.Gui;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameLoop {

    public static final GameLoop gameLoop = new GameLoop();
    private GameLoop() {}

    private Hero hero;
    private final List<Hero> enemiesHero = new ArrayList<>();
    private ViewMode viewMode;
    private Map map;

    public void LaunchGame(String gameViewMode) {
        if (gameViewMode.equals("gui"))
            this.viewMode = new Gui();
        this.map = new Map(1);
        this.hero = new Fizz("Name");
        this.viewMode.DisplayToPosition(this.map.getCurrentMapSize() * 64 / 2 - 32, this.map.getCurrentMapSize() * 64 / 2 - 32, this.hero.getImage());
        this.viewMode.DisplayPlayerInfos(this.hero);
        /*while(1 != 2) {

        }*/
    }

    public void GenerateNewMap() {
        this.map = new Map(this.hero.getLevel());
        this.viewMode.DisplayToPosition(this.map.getCurrentMapSize() * 64 / 2 - 32, this.map.getCurrentMapSize() * 64 / 2 - 32, this.hero.getImage());
        this.CreateEnemies();
    }

    public void PlayerWinMap() {
        this.hero.addExperience(1000);
        this.GenerateNewMap();
        this.viewMode.DisplayToPosition(this.map.getCurrentMapSize() * 64 / 2 - 32, this.map.getCurrentMapSize() * 64 / 2 - 32, this.hero.getImage());
    }

    private void CreateEnemies() {
        Random randomNumbers = new Random();
        Boss boss = new Boss("BossAI");
        Shaco shaco = new Shaco("ShacoAI");
        this.viewMode.DisplayToPosition(64 * randomNumbers.nextInt(this.map.getCurrentMapSize()), 64 * randomNumbers.nextInt(this.map.getCurrentMapSize()), boss.getImage());
        this.viewMode.DisplayToPosition(64 * randomNumbers.nextInt(this.map.getCurrentMapSize()), 64 * randomNumbers.nextInt(this.map.getCurrentMapSize()), shaco.getImage());

        this.enemiesHero.add(boss);
        this.enemiesHero.add(shaco);
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
