package com.alihaine.avaj.aircraft;

import com.alihaine.avaj.weather.WeatherTower;

public class Aircraft extends Flyable {

    protected WeatherTower weatherTower;
    protected long id;
    protected String name;
    protected Coordinates coordinates;

    protected Aircraft(long p_id, String p_name, Coordinates p_coordinates) {
        this.id = p_id;
        this.name = p_name;
        this.coordinates = p_coordinates;
    }

    @Override
    public void updateConditions() {

    }
}
