package com.alihaine.avaj.weather;

import com.alihaine.avaj.Avaj;
import com.alihaine.avaj.aircraft.Aircraft;
import com.alihaine.avaj.aircraft.Flyable;

import java.util.ArrayList;
import java.util.List;

public class Tower {

    List<Flyable> observers = new ArrayList<>();

    public void register(Flyable p_flyable) {
        Aircraft aircraft = (Aircraft) p_flyable;
        Avaj.fileManager.writeSimulationLine("Tower says: " + aircraft.getName() + "("+ aircraft.getId() + ")" +  " registered to weather tower.");
        this.observers.add(p_flyable);
    }

    public void unregister(Flyable p_flyable) {
        Aircraft aircraft = (Aircraft) p_flyable;
        Avaj.fileManager.writeSimulationLine("Tower says: " + aircraft.getName() + "("+ aircraft.getId() + ")" +  " unregistered from weather tower.");
        this.observers.remove(p_flyable);
    }

    protected void conditionChanged() {
        List<Aircraft> toUnregister = new ArrayList<>();
        for (Flyable observers : observers) {
            observers.updateConditions();
            Aircraft aircraft = (Aircraft) observers;
            if (aircraft.getCoordinates().getHeight() <= 0)
                toUnregister.add(aircraft);
        }

        for (Aircraft aircraft : toUnregister)
            this.unregister(aircraft);
    }
}
