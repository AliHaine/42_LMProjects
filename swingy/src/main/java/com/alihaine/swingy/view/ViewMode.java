package com.alihaine.swingy.view;

import javax.swing.*;

public abstract class ViewMode {


    public void DisplayToPosition(int x, int y, JLabel jLabel) {
        System.out.println("This mode of view can't call this function please fix your code");
    }
    public void DisplayToPosition(int x, int y, char character) {
        System.out.println("This mode of view can't call this function please fix your code");
    }
    public abstract void DisplayMap(int mapSize);
}
