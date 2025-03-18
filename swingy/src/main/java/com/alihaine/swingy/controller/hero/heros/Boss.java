package com.alihaine.swingy.controller.hero.heros;

import com.alihaine.swingy.controller.hero.Hero;
import com.alihaine.swingy.view.gui.Images;

import javax.swing.*;

public class Boss extends Hero {
    public Boss(String name) {
        super(name, "Boss", new JLabel(Images.images.getImageIconFromPath("boss")),1, 0, 5, 5, 150);
    }
}
