package com.alihaine.avaj.aircraft;

import com.alihaine.avaj.weather.WeatherTower;

public interface Flyable {

    public abstract void updateConditions();
    default void registerTower(WeatherTower p_tower) {

    }
}
