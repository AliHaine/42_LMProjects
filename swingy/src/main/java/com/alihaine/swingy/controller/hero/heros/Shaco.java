package com.alihaine.swingy.controller.hero.heros;

import com.alihaine.swingy.controller.MathRand;
import com.alihaine.swingy.controller.hero.Hero;
import com.alihaine.swingy.view.gui.Images;

import javax.swing.*;

public class Shaco extends Hero {
    public Shaco(String name) {
        super(name, "Shaco", new JLabel(Images.images.getImageIconFromPath("shaco")),1, 0, MathRand.getRandom(50), 5, 70);
    }
}
