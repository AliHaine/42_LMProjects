package com.alihaine.swingy.controller.hero.heros;

import com.alihaine.swingy.controller.MathRand;
import com.alihaine.swingy.controller.hero.Hero;
import com.alihaine.swingy.view.gui.Images;

import javax.swing.*;
import java.util.List;

public class Shaco extends Hero {
    public Shaco(String name) {
        super(name, "Shaco", new JLabel(Images.images.getImageIconFromPath("shaco")),1, 0, MathRand.getRandom(50), 5, 70);
    }

    public Shaco(List<String> values) {
        super(values.get(1), values.get(2), new JLabel(Images.images.getImageIconFromPath("shaco")), Integer.parseInt(values.get(3)),  Integer.parseInt(values.get(4)),  Integer.parseInt(values.get(5)),  Integer.parseInt(values.get(6)),  Integer.parseInt(values.get(7)));
        this.setId(Integer.parseInt(values.get(0)));
    }
}
