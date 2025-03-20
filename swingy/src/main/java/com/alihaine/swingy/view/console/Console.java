package com.alihaine.swingy.view.console;

import com.alihaine.swingy.controller.Creator;
import com.alihaine.swingy.controller.GameLoop;
import com.alihaine.swingy.controller.hero.Hero;
import com.alihaine.swingy.model.Database;
import com.alihaine.swingy.view.ViewMode;
import com.sun.istack.internal.NotNull;
import jakarta.validation.constraints.Pattern;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Console implements ViewMode {

    private final char wall = '■';
    private final char player = 'P';
    private final char enemy = 'E';
    public boolean activated = false;
    private final List<List<Character>> mapAsChar = new ArrayList<>();

    public Console(Hero hero) {
        this.activated = true;
        GameLoop.gameLoop.setViewMode(this);
        GameLoop.gameLoop.RunGame(hero);
    }

    public Console() {
        this.activated = true;
        Scanner userInput = new Scanner(System.in);
        Hero hero = null;
        while (activated) {
            System.out.println("Welcome, choose an action: ");
            System.out.println("create <name> Fizz | Shaco | Yasuo");
            System.out.println("select <id>");
            //@NotNull @Pattern(regexp = "^[a-zA-Z]+$", message = "Only letters allowed")
            String input;
            try {
                input = userInput.nextLine();
                if (input.contains("create")) {
                    final String[] values = input.split(" ");
                    if (!this.CheckInputs(values)) {
                        System.out.println("Error with " + input);
                        continue;
                    }
                    hero = Creator.HeroCreator(values[1], values[2]);
                    Database.db.AddData(hero);
                    hero.setId( Database.db.GetLastId());
                    break;
                } else if (input.contains("select")) {
                    final String[] values = input.split(" ");
                    final int val;
                    try {
                        val = Integer.parseInt(values[1]);
                    } catch (Exception e) {
                        System.out.println("Error with selection");
                        continue;
                    }
                    final List<String> heroAsString = Database.db.GetDatabaseRow(val);
                    if (heroAsString == null) {
                        System.out.println("No hero with this id found..");
                        continue;
                    }
                    hero = Creator.HeroCreator(heroAsString);
                    break;
                }

                System.out.println("Action not found, try again");
            } catch (Exception e) {
                System.exit(0);
            }
        }
        GameLoop.gameLoop.setViewMode(this);
        GameLoop.gameLoop.RunGame(hero);
    }

    private boolean CheckInputs(String[] inputs) {
        if (inputs.length != 3)
            return false;
        else if (!inputs[0].equalsIgnoreCase("create"))
            return false;
        else if (inputs[1].isEmpty() || inputs[1].length() > 100)
            return false;
        else if (!inputs[2].equalsIgnoreCase("shaco") && !inputs[2].equalsIgnoreCase("fizz") && !inputs[2].equalsIgnoreCase("yasuo"))
            return false;
        return true;
    }

    public void InitConsole() {
        Scanner userInput = new Scanner(System.in);
        while (this.activated) {
            for (List<Character> lines : mapAsChar) {
                for (Character character : lines) {
                    System.out.print(character);
                }
                System.out.print('\n');
            }
            System.out.println("----------------------------------------------");
            System.out.print("Action to do: ");
            //@NotNull @Pattern(regexp = "^[a-zA-Z]+$", message = "Only letters allowed")
            String input;
            try {
                input = userInput.next();
            } catch (Exception e) {
                break;
            }
            GameLoop.gameLoop.InputTrigger(input);
        }
        System.out.println("Good bye.");
    }

    @Override
    public void DisplayToPosition(int x, int y, Hero hero) {
        if (this.IsOutOfTheMap(x, y)) {
            GameLoop.gameLoop.PlayerWinMap();
            return;
        }

        if (hero == null) {
            this.mapAsChar.get(y).set(x, this.wall);
            return;
        }

        if (hero == GameLoop.gameLoop.getCurrentHero())
            this.mapAsChar.get(y).set(x, this.player);
        else
            this.mapAsChar.get(y).set(x, this.enemy);
        hero.setCurrentPos(x, y);
    }

    @Override
    public void DisplayMap(int mapSize) {
        this.mapAsChar.clear();
        int i = 0;
        while (i < mapSize) {
            final List<Character> newLine = new ArrayList<>();
            for (int j = 0; j < mapSize; j++)
                newLine.add(wall);
            this.mapAsChar.add(newLine);
            i++;
        }
    }

    @Override
    public void DisplayPlayerInfos(Hero hero) {
        System.out.println("Hero name " + hero.getName() +  " with the champ " + hero.getChamp());
        System.out.println("Level: " + hero.getLevel() +  " with " + hero.getExperience() + " exp");
        System.out.println("Stats: " + "Attack: " + hero.getAttack() + " | " + " Defense: " + hero.getDefense() + " | " + " HP: " + hero.getHitPoint());

    }

    @Override
    public void DisplayFight(List<String> logs) {
        for (String line : logs)
            System.out.println(line);
    }

    @Override
    public boolean IsOutOfTheMap(int x, int y) {
        if (y >= GameLoop.gameLoop.getMap().getCurrentMapSize() || x >= GameLoop.gameLoop.getMap().getCurrentMapSize() || y < 0 || x < 0)
            return true;
        return false;
    }
}
