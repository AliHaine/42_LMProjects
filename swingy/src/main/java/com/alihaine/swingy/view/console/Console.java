package com.alihaine.swingy.view.console;

import com.alihaine.swingy.controller.hero.Hero;
import com.alihaine.swingy.view.ViewMode;

import javax.swing.text.View;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Console implements ViewMode {

    private final char wall = '■';
    private final char player = 'P';
    private final char enemy = 'E';
    private final List<List<Character>> mapAsChar = new ArrayList<>(new ArrayList<>());

    public Console() {}

    public void InitConsole() {
        Scanner userInput = new Scanner(System.in);
        while (true) {
            for (List<Character> lines : mapAsChar) {
                for (Character character : lines) {
                    System.out.print(character);
                }
                System.out.print('\n');
            }
            String input = userInput.next();
        }
    }

    @Override
    public void DisplayToPosition(int x, int y, Hero hero) {
        this.mapAsChar.get(y).set(x, 'P');
    }

    @Override
    public void DisplayMap(int mapSize) {
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

    }

    @Override
    public void DisplayFight(List<String> logs) {

    }

    @Override
    public boolean IsOutOfTheMap(int x, int y) {
        return false;
    }

    private boolean IsAWall() {
        return false;
    }
}
