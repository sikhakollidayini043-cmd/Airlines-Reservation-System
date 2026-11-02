package com.airlines.model;

import java.io.Serializable;

public class Booking implements Serializable {

    private static final long serialVersionUID = 1L;

    private int bookingId;
    private Passenger passenger;
    private Flight flight;

    public Booking(int bookingId, Passenger passenger,
                   Flight flight) {
        this.bookingId = bookingId;
        this.passenger = passenger;
        this.flight = flight;
    }

    public int getBookingId() {
        return bookingId;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public Flight getFlight() {
        return flight;
    }

    @Override
    public String toString() {
        return "\nBooking ID: " + bookingId    + "\nPassenger: " + passenger.getName()
                + "\nFlight: " + flight.getFlightName()
                + "\nRoute: " + flight.getSource()
                + " -> " + flight.getDestination()
                + "\nFare: Rs." + flight.getFare();
    }
}