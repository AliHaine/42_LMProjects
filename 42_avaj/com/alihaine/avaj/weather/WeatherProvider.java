package com.alihaine.avaj.weather;

import com.alihaine.avaj.aircraft.Coordinates;

import java.util.Arrays;
import java.util.List;

public class WeatherProvider {

    private final List<String> weather = Arrays.asList("SUN", "RAIN", "FOG", "SNOW");
    private static final WeatherProvider weatherProvider = new WeatherProvider();

    private WeatherProvider() {}

    public static WeatherProvider getInstance() { return weatherProvider; }

    public String getCurrentWeather(Coordinates p_coordinates) {
        return weather.get((p_coordinates.getHeight() + p_coordinates.getLatitude() + p_coordinates.getLongitude()) % 4);
    }
}
