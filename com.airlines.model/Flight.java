package com.airlines.model;

import java.io.Serializable;

public class Flight implements Serializable {

    private static final long serialVersionUID = 1L;

    private int flightId;
    private String flightName;
    private String source;
    private String destination;
    private double fare;
    private int availableSeats;

    public Flight(int flightId, String flightName,
                  String source, String destination,
                  double fare, int availableSeats) {

        this.flightId = flightId;
        this.flightName = flightName;
        this.source = source;
        this.destination = destination;
        this.fare = fare;
        this.availableSeats = availableSeats;
    }

    public int getFlightId() {
        return flightId;
    }

    public String getFlightName() {
        return flightName;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public double getFare() {
        return fare;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public boolean bookSeat() {
        if (availableSeats > 0) {
            availableSeats--;
            return true;
        }
        return false;
    }

    public void cancelSeat() {
        availableSeats++;
    }

    @Override
    public String toString() {
        return flightId + " | " + flightName
                + " | " + source + " -> " + destination
                + " | Rs." + fare
                + " | Seats: " + availableSeats;
    }
}