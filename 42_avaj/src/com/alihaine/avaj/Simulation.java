package com.alihaine.avaj;

import com.alihaine.avaj.aircraft.AircraftFactory;

public class Simulation {

    private int loop;
    private final AircraftFactory  aircraftFactory = AircraftFactory.getInstance();

    public Simulation() {
        this.loop = 5;
        String line;

        while (Avaj.fileManager.scenarioHasNextLine()) {
            line = Avaj.fileManager.getScenarioNextLine();;
        }


        while (loop-- > 0) {


        }
    }
}
