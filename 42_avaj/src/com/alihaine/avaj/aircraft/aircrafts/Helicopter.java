package com.alihaine.avaj.aircraft.aircrafts;

import com.alihaine.avaj.aircraft.Aircraft;
import com.alihaine.avaj.aircraft.Coordinates;

import java.util.Map;

public class Helicopter extends Aircraft  {

    public Helicopter(long p_id, String p_name, Coordinates p_coordinates) {
        super(p_id, p_name, p_coordinates);
    }
    private Map<String, Map<String, Integer>> conditions = Map.of(
            "SUN", Map.of("Longitude", 10, "Height", 2),
            "RAIN", Map.of("Longitude", 5),
            "FOG", Map.of("Longitude", 1),
            "SNOW", Map.of("Height", -12)
    );

    @Override
    public void updateConditions() {
        String currentWeather = this.weatherTower.getWeather(this.coordinates);
    }
}
