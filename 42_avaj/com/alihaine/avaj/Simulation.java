package com.alihaine.avaj;

import com.alihaine.avaj.aircraft.AircraftFactory;
import com.alihaine.avaj.aircraft.Coordinates;
import com.alihaine.avaj.aircraft.Flyable;
import com.alihaine.avaj.weather.WeatherTower;

public class Simulation {

    public Simulation() throws CustomExceptions {
        int loop;
        try {
            loop = Integer.parseInt(Avaj.fileManager.getScenarioNextLine());
            if (loop <= 0)
                throw new CustomExceptions("The first line of the file is not a valid number");
        } catch (NumberFormatException e) {
            throw new CustomExceptions("The first line of the file is not a valid number");
        }

        WeatherTower weatherTower = new WeatherTower();
        String line;

        while (Avaj.fileManager.scenarioHasNextLine()) {
            line = Avaj.fileManager.getScenarioNextLine();
            String[] values = line.split(" ");
            if (!this.checkValues(values))
                throw new CustomExceptions("The line " + line + " is not valid");
            int[] positions = {Integer.parseInt(values[2]), Integer.parseInt(values[3]), Integer.parseInt(values[4])};
            Flyable flyable = AircraftFactory.getInstance().newAirCraft(values[0], values[1], new Coordinates(positions[0], positions[1], positions[2]));
            flyable.registerTower(weatherTower);
            weatherTower.register(flyable);
        }

        while (loop-- > 0)
            weatherTower.changeWeather();
    }

    private boolean checkValues(String[] values) {
        if (values.length != 5)
            return false;
        else if (!values[0].equals("Helicopter") && !values[0].equals("Baloon") && !values[0].equals("JetPlane"))
            return false;

        for (int i = 2; i < 5; i++) {
            try {
                int value = Integer.parseInt(values[i]);
                if (value <= 0)
                    return false;
            } catch (NumberFormatException e) {
                return false;
            }
        }
        return true;
    }
}
