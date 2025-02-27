package com.alihaine.avaj.weather;

import com.alihaine.avaj.aircraft.Flyable;

import java.util.ArrayList;
import java.util.List;

public class Tower {

    List<Flyable> observers = new ArrayList<>();

    public void register(Flyable p_flyable) {
        this.observers.add(p_flyable);
    }

    public void unregister(Flyable p_flyable) {
        this.observers.remove(p_flyable);
    }

    protected void conditionChanged() {
        for (Flyable observers : observers)
            observers.updateConditions();
    }
}
