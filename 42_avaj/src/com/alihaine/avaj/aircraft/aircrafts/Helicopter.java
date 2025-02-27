package com.alihaine.avaj.aircraft.aircrafts;

import com.alihaine.avaj.aircraft.Aircraft;
import com.alihaine.avaj.aircraft.Coordinates;
import com.alihaine.avaj.aircraft.Flyable;
import com.alihaine.avaj.weather.WeatherType;

import java.util.Map;

public class Helicopter extends Aircraft implements Flyable {

    protected Helicopter(long p_id, String p_name, Coordinates p_coordinates) {
        super(p_id, p_name, p_coordinates);
    }
    private Map<WeatherType, Map<String, Integer>> conditions = Map.of(
            WeatherType.SUN, Map.of("Longitude", 10, "Height", 2),
            WeatherType.RAIN, Map.of("Longitude", 5),
            WeatherType.FOG, Map.of("Longitude", 1),
            WeatherType.SNOW, Map.of("Height", -12)
    );

    @Override
    public void updateConditions() {

    }
}
