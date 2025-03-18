package com.alihaine.swingy.controller.hero.heros;

import com.alihaine.swingy.controller.hero.Hero;
import com.alihaine.swingy.view.gui.Images;

import javax.swing.*;

public class Yasuo extends Hero {
    public Yasuo(String name) {
        super(name, "Yasuo", new JLabel(Images.images.getImageIconFromPath("yasuo")),1, 0, 10, 2, 120);
    }
}
