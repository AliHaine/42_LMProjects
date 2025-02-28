package com.alihaine.avaj.aircraft;

import com.alihaine.avaj.Avaj;

public class Aircraft extends Flyable {

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

    public long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public Coordinates getCoordinates() {
        return this.coordinates;
    }

    protected String getPrefix() {
        return this.getClass().getSimpleName() + "#" + this.getName() + "(" + this.getId() + ")";
    }

    protected void printMsgFromWeather(String weather) {
        if (weather.equals("SUN"))
            Avaj.fileManager.writeSimulationLine(this.getPrefix() + ": Let's enjoy the good weather and take some pics.");
        else if (weather.equals("RAIN"))
            Avaj.fileManager.writeSimulationLine(this.getPrefix() + ": It's raining. Better watch out for lightings.");
        else if (weather.equals("FOG"))
            Avaj.fileManager.writeSimulationLine(this.getPrefix() + ": NICE! FOGGING!");
        else
            Avaj.fileManager.writeSimulationLine(this.getPrefix() + ": OMG! Winter is coming!");
    }
}
