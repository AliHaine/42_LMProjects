package com.alihaine.swingy.view;

import com.alihaine.swingy.controller.hero.Hero;

import javax.swing.*;
import java.util.List;

public interface ViewMode {
    void DisplayToPosition(int x, int y, Hero hero);
    void DisplayMap(int mapSize);
    void DisplayPlayerInfos(Hero hero);
    void DisplayFight(List<String> logs);
    boolean IsOutOfTheMap(int x, int y);
}
