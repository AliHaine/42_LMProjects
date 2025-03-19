package com.alihaine.swingy.view.console;

import com.alihaine.swingy.controller.GameLoop;
import com.alihaine.swingy.controller.hero.Hero;
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
    private final List<List<Character>> mapAsChar = new ArrayList<>();

    public Console() {
        Scanner userInput = new Scanner(System.in);
        while (true) {
            System.out.println("Welcome, choose an action: ");
            System.out.println("create <name> Fizz | Shaco | Yasuo");
            System.out.println("select <id>");
            //@NotNull @Pattern(regexp = "^[a-zA-Z]+$", message = "Only letters allowed")
            String input;
            try {
                input = userInput.next();
                if (input.contains("create")) {

                } else if (input.contains("select")) {

                }

                System.out.println("Action not found, try again");
            } catch (Exception e) {
                System.exit(0);
            }
        }

    }

    public void InitConsole() {
        Scanner userInput = new Scanner(System.in);
        while (true) {
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
