package com.alihaine.avaj.aircraft.aircrafts;

import com.alihaine.avaj.aircraft.Aircraft;
import com.alihaine.avaj.aircraft.Coordinates;

import java.util.Map;

public class Baloon extends Aircraft {
    public Baloon(long p_id, String p_name, Coordinates p_coordinates) { super(p_id, p_name, p_coordinates); }
    private final Map<String, Map<String, Integer>> conditions = Map.of(
            "SUN", Map.of("Longitude", 2, "Height", 4),
            "RAIN", Map.of("Height", -5),
            "FOG", Map.of("Height", -3),
            "SNOW", Map.of("Height", -15)
    );

    @Override
    public void updateConditions() {
        String currentWeather = this.weatherTower.getWeather(this.coordinates);
        int height = this.coordinates.getHeight();
        int longitude = this.coordinates.getLongitude();
        if (currentWeather.equals("SUN"))
            longitude += this.conditions.get("SUN").get("Longitude");
        height += this.conditions.get(currentWeather).get("Height");
        this.coordinates = new Coordinates(longitude, this.coordinates.getLatitude(), height);
        this.printMsgFromWeather(currentWeather);
    }
}
