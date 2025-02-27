package com.alihaine.avaj.aircraft;

public class Coordinates {

    private final int longitude;
    private final int latitude;
    private final int height;

    public Coordinates(int p_longitude, int p_latitude, int p_height) {
        this.longitude = p_longitude;
        this.latitude = p_latitude;
        this.height = p_height;
    }

    public int getLongitude() {
        return longitude;
    }

    public int getHeight() {
        return height;
    }

    public int getLatitude() {
        return latitude;
    }
}
