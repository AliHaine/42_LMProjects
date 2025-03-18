package com.alihaine.swingy.view.console;

import com.alihaine.swingy.controller.hero.Hero;
import com.alihaine.swingy.view.ViewMode;

import javax.swing.text.View;

public class Console extends ViewMode {
    @Override
    public void DisplayMap(int mapSize) {

    }

    @Override
    public void DisplayPlayerInfos(Hero hero) {

    }

    @Override
    public boolean IsOutOfTheMap(int x, int y) {
        return false;
    }
}
