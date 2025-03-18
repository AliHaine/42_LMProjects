package com.alihaine.swingy.view.console;

import com.alihaine.swingy.controller.hero.Hero;
import com.alihaine.swingy.view.ViewMode;

import javax.swing.text.View;
import java.util.List;

public class Console extends ViewMode {
    @Override
    public void DisplayMap(int mapSize) {

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
}
