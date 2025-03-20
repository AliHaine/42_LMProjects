package com.alihaine.swingy.controller.hero.heros;

import com.alihaine.swingy.controller.hero.Hero;
import com.alihaine.swingy.view.gui.Images;

import javax.swing.*;
import java.util.List;

public class Fizz extends Hero {
    public Fizz(String name) {
        super(name, "Fizz", new JLabel(Images.images.getImageIconFromPath("fizz")),1, 0, 15, 3, 100);
    }

    public Fizz(List<String> values) {
        super(values.get(1), values.get(2), new JLabel(Images.images.getImageIconFromPath("fizz")), Integer.parseInt(values.get(3)),  Integer.parseInt(values.get(4)),  Integer.parseInt(values.get(5)),  Integer.parseInt(values.get(6)),  Integer.parseInt(values.get(7)));
        this.setId(Integer.parseInt(values.get(0)));
    }
}
