package com.airlines.service;

import java.util.ArrayList;

import com.airlines.model.Flight;
import com.airlines.util.FileHandler;

public class FlightService {

    private ArrayList<Flight> flightList;

    private final String FILE = "flights.dat";

    @SuppressWarnings("unchecked")
    public FlightService() {

        Object data = FileHandler.loadObject(FILE);

        if (data instanceof ArrayList<?>) {
            flightList = (ArrayList<Flight>) data;
        } else {
            flightList = new ArrayList<>();

            flightList.add(new Flight(101, "IndiGo",
                    "Vijayawada", "Hyderabad", 3500, 50));

            flightList.add(new Flight(102, "Air India",
                    "Vijayawada", "Bangalore", 4500, 40));

            flightList.add(new Flight(103, "SpiceJet",
                    "Hyderabad", "Delhi", 5500, 35));

            saveFlights();
        }
    }

    public void addFlight(Flight flight) {
        flightList.add(flight);
        saveFlights();
        System.out.println("Flight added successfully!");
    }

    public void viewFlights() {

        System.out.println("\n========== AVAILABLE FLIGHTS ==========");

        if (flightList.isEmpty()) {
            System.out.println("No flights available.");
            return;
        }

        for (Flight flight : flightList) {
            System.out.println(flight);
        }
    }

    public Flight searchFlight(int flightId) {

        for (Flight flight : flightList) {

            if (flight.getFlightId() == flightId) {
                return flight;
            }
        }

        return null;
    }

    public void saveFlights() {
        FileHandler.saveObject(flightList, FILE);
    }
}