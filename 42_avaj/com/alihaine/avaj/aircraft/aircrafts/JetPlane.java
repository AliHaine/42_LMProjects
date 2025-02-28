package com.alihaine.avaj.aircraft.aircrafts;

import com.alihaine.avaj.aircraft.Aircraft;
import com.alihaine.avaj.aircraft.Coordinates;

import java.util.Map;

public class JetPlane extends Aircraft {

    public JetPlane(long p_id, String p_name, Coordinates p_coordinates) { super(p_id, p_name, p_coordinates); }
    private final Map<String, Map<String, Integer>> conditions = Map.of(
            "SUN", Map.of("Latitude", 10, "Height", 2),
            "RAIN", Map.of("Latitude", 5),
            "FOG", Map.of("Latitude", 1),
            "SNOW", Map.of("Height", -7)
    );

    @Override
    public void updateConditions() {
        String currentWeather = this.weatherTower.getWeather(this.coordinates);
        int height = this.coordinates.getHeight();
        int Latitude = this.coordinates.getLongitude();
        if (currentWeather.equals("SNOW")){
            height += this.conditions.get("SNOW").get("Height");
        } else {
            Latitude += this.conditions.get(currentWeather).get("Latitude");
            if (currentWeather.equals("SUN"))
                height += this.conditions.get("SUN").get("Height");
        }
        this.coordinates = new Coordinates(this.coordinates.getLongitude(), Latitude, height);
        this.printMsgFromWeather(currentWeather);
    }
}
