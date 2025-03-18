package com.alihaine.swingy.view;

import com.alihaine.swingy.controller.hero.Hero;

import javax.swing.*;
import java.util.List;

public abstract class ViewMode {


    public void DisplayToPosition(int x, int y, JLabel jLabel) {
        System.out.println("This mode of view can't call this function please fix your code");
    }
    public void DisplayToPosition(int x, int y, char character) {
        System.out.println("This mode of view can't call this function please fix your code");
    }
    public abstract void DisplayMap(int mapSize);
    public abstract void DisplayPlayerInfos(Hero hero);
    public abstract void DisplayFight(List<String> logs);
    public abstract boolean IsOutOfTheMap(int x, int y);
}
