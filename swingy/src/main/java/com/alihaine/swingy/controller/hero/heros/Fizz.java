package com.alihaine.swingy.controller.hero.heros;

import com.alihaine.swingy.controller.hero.Hero;
import com.alihaine.swingy.view.gui.Images;

import javax.swing.*;

public class Fizz extends Hero {
    public Fizz(String name) {
        super(name, "Fizz", new JLabel(Images.images.getImageIconFromPath("fizz")),1, 0, 15, 15, 100);
    }
}
