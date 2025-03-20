package com.alihaine.swingy.controller;

import com.alihaine.swingy.controller.hero.Hero;
import com.alihaine.swingy.controller.hero.heros.Fizz;
import com.alihaine.swingy.controller.hero.heros.Shaco;
import com.alihaine.swingy.controller.hero.heros.Yasuo;

import java.util.List;

public class Creator {

    public static Hero HeroCreator(String name, String type) {
        if (type.equalsIgnoreCase("fizz"))
            return new Fizz(name);
        else if (type.equalsIgnoreCase("shaco"))
            return new Shaco(name);
        else
            return new Yasuo(name);
    }

    public static Hero HeroCreator(List<String> values) {
        if (values.get(2).equalsIgnoreCase("fizz"))
            return new Fizz(values);
        else if (values.get(2).equalsIgnoreCase("shaco"))
            return new Shaco(values);
        else
            return new Yasuo(values);
    }

}
