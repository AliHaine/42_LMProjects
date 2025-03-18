package com.alihaine.swingy.controller;

import com.alihaine.swingy.controller.hero.Hero;
import com.alihaine.swingy.controller.hero.heros.Boss;
import com.alihaine.swingy.controller.hero.heros.Fizz;
import com.alihaine.swingy.controller.hero.heros.Shaco;
import com.alihaine.swingy.view.ViewMode;
import com.alihaine.swingy.view.gui.Gui;

import java.util.ArrayList;
import java.util.List;

public class GameLoop {

    public static final GameLoop gameLoop = new GameLoop();
    private GameLoop() {}

    private Hero hero;
    private final List<Hero> enemiesHero = new ArrayList<>();
    private ViewMode viewMode;
    private Map map;
    private String artifact = "";
    public int stats = 0; //0 = no in combat, 1 == wait for fight or leave, 2 == in combat, 3 == keep or not
    private Hero currentEnemy;

    public void LaunchGame(String gameViewMode) {
        if (gameViewMode.equals("gui"))
            this.viewMode = new Gui();
        this.map = new Map(1);
        this.hero = new Fizz("MySuperFizz");
        this.viewMode.DisplayToPosition(this.map.getCurrentMapSize() * 64 / 2 - 32, this.map.getCurrentMapSize() * 64 / 2 - 32, this.hero.getImage());
        this.viewMode.DisplayPlayerInfos(this.hero);
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
        Boss boss = new Boss("BossAI");
        Shaco shaco = new Shaco("ShacoAI");
        this.viewMode.DisplayToPosition(64 * MathRand.getRandom((this.map.getCurrentMapSize())), 64 * MathRand.getRandom((this.map.getCurrentMapSize())), boss.getImage());
        this.viewMode.DisplayToPosition(64 * MathRand.getRandom((this.map.getCurrentMapSize())), 64 * MathRand.getRandom((this.map.getCurrentMapSize())), shaco.getImage());

        this.enemiesHero.add(boss);
        this.enemiesHero.add(shaco);
    }

    public void PlayerMoveTrigger() {
        Hero enemyHero = this.IsPlayerInAnEnemy();
        if (enemyHero != null) {
            this.currentEnemy = enemyHero;
            this.stats = 1;
        }
    }

    public void LaunchFight() {
        final List<String> combatLogs = new ArrayList<>();
        this.stats = 2;

        while (currentEnemy.getHitPoint() > 0 && this.hero.getHitPoint() > 0) {
            this.FightHit(combatLogs, this.hero, currentEnemy);
            this.FightHit(combatLogs, currentEnemy, this.hero);
        }

        Hero winner = this.hero.getHitPoint() > 0 ? this.hero : currentEnemy;
        combatLogs.add(winner.getName() + " won");
        this.viewMode.DisplayFight(combatLogs);

        if (this.hero.getHitPoint() > 0) {
            this.hero.addExperience(300 * currentEnemy.getLevel());
            this.generateArtifact();
            currentEnemy.getImage().setVisible(false);
            this.enemiesHero.remove(currentEnemy);
            this.currentEnemy = null;
            this.stats = 3;
        } else {
            this.stats = -1;
            this.hero.getImage().setVisible(false);
        }
    }

    public void TryToRun() {
        if (MathRand.getBoolRand())
            System.out.println("run");
        else
            this.LaunchFight();
    }

    private void FightHit(List<String> logs, Hero sender, Hero target) {
        logs.add(sender.getName() + " attack " + target.getName());
        logs.add(target.getName() + " lost " + (sender.getAttack() - sender.getDefense()) + " hp ");
        target.setHitPoint(target.getHitPoint() - (sender.getAttack() - sender.getDefense()));
    }

    private Hero IsPlayerInAnEnemy() {
        int x, y;
        x = this.getCurrentHero().getImage().getX();
        y = this.getCurrentHero().getImage().getY();

        for (Hero enemy : this.enemiesHero) {
            if (enemy.getImage().getX() == x && enemy.getImage().getY() == y)
                return enemy;
        }
        return null;
    }

    private void generateArtifact() {
        int value = MathRand.getRandom(3);
        if (value == 0)
            this.artifact = "Helm " + this.currentEnemy.getLevel() * 3;
        else if (value == 1)
            this.artifact = "Weapon " + this.currentEnemy.getLevel() * 3;
        else
            this.artifact = "Armor " + this.currentEnemy.getLevel() * 3;

    }

    public void LeaveArtifact() {
        this.artifact = "";
        this.stats = 0;
    }

    public void KeepArtifact() {
        if (this.artifact.isEmpty())
            return;
        String[] values = this.artifact.split(" ");
        int value = Integer.parseInt(values[1]);
        if (values[0].equals("Helm"))
            this.hero.setHitPoint(this.hero.getHitPoint() + value);
        else if (values[0].equals("Weapon"))
            this.hero.setAttack(this.hero.getAttack() + value);
        else
            this.hero.setDefense(this.hero.getDefense() + value);
        this.stats = 0;
        this.viewMode.DisplayPlayerInfos(this.hero);
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
