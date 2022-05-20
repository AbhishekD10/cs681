package edu.umb.cs681.hw10;

import java.util.ArrayList;

public final class Position {
    private final double longitude;
    private final double altitude;
    private final double latitude;


    public Position(double latitude, double longitude, double altitude) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.altitude = altitude;
    }
    
    public double getLatitude(){
        return this.latitude;
    }
    
    public double getLongitude() {
        return this.longitude;
    }

    public double getAltitude() {
        return this.altitude;
    }
    
    public String toString(){
        return latitude + "," + longitude + "," + altitude ;
    }
    public boolean equals(Position otherposition) {
        if(this.toString().equals(otherposition.toString())) {
        	return true;
        	}
        else {
        	return false;
        	}
    }
    
    public ArrayList<Double> getCoordinate() {
        ArrayList<Double> coordinates = new ArrayList<>();
        coordinates.add(latitude);
        coordinates.add(longitude);
        coordinates.add(altitude);
        return coordinates;
    }

    public Position changeLatitude(double newLatitude) {
        return new Position(newLatitude, this.longitude, this.altitude);
    }

    public Position changeLongitude(double newLongitude) {
        return new Position(this.latitude, newLongitude, this.altitude);
    }

    public Position changeAltitude(double newAltitude) {
        return new Position(this.latitude, this.longitude, newAltitude);
    }

}