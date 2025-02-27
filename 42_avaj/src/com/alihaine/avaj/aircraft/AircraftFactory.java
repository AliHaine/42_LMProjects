package com.alihaine.avaj.aircraft;

import com.alihaine.avaj.aircraft.aircrafts.Helicopter;

public class AircraftFactory {

    private long currentId = 0;
    private static final AircraftFactory aircraftFactory = new AircraftFactory();

    private AircraftFactory() {}

    public static AircraftFactory getInstance() { return aircraftFactory; }

    public Flyable newAirCraft(String p_type, String p_name, Coordinates p_coordinates) {
        if (p_type.equals("Helicopter"))
            return new Helicopter(this.currentId++, p_name, p_coordinates);
        return null;
    }
}
