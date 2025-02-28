package com.alihaine.avaj.aircraft;

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

    protected void printMsgFromWeather(String weather) {
        if (weather.equals("SUN"))
            System.out.println(this.getName() + "(" + this.getId() + "):" + "  Let's enjoy the good weather and take some pics.");
        else if (weather.equals("RAIN"))
            System.out.println(this.getName() + "(" + this.getId() + "):" + " It's raining. Better watch out for lightings.");
        else if (weather.equals("FOG"))
            System.out.println(this.getName() + "(" + this.getId() + "):" + "  NICE! FOGGING!");
        else
            System.out.println(this.getName() + "(" + this.getId() + "):" + "  OMG! Winter is coming!");
    }
}
