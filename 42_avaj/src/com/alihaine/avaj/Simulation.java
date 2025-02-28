package com.alihaine.avaj;

import com.alihaine.avaj.aircraft.AircraftFactory;
import com.alihaine.avaj.aircraft.Coordinates;
import com.alihaine.avaj.aircraft.Flyable;
import com.alihaine.avaj.weather.WeatherTower;

public class Simulation {

    public Simulation() {
        int loop;
        try {
            loop = Integer.parseInt(Avaj.fileManager.getScenarioNextLine());
        } catch (NumberFormatException e) {
            System.out.println(e);
            return;
        }

        WeatherTower weatherTower = new WeatherTower();
        String line;

        while (Avaj.fileManager.scenarioHasNextLine()) {
            line = Avaj.fileManager.getScenarioNextLine();
            String[] values = line.split(" ");
            int[] positions = {Integer.parseInt(values[2]), Integer.parseInt(values[3]), Integer.parseInt(values[4])};
            Flyable flyable = AircraftFactory.getInstance().newAirCraft(values[0], values[1], new Coordinates(positions[0], positions[1], positions[2]));
            flyable.registerTower(weatherTower);
            weatherTower.register(flyable);
        }

        while (loop-- > 0)
            weatherTower.changeWeather();
    }
}
