package com.airlines.service;

import com.airlines.model.Flight;

public class AdminService {

    private FlightService flightService;

    public AdminService(FlightService flightService) {
        this.flightService = flightService;
    }

    public boolean login(String email, String password) {

        return email.equals("admin@gmail.com")
                && password.equals("Admin@123");
    }

    public void addFlight(int id, String name,
                          String source, String destination,
                          double fare, int seats) {

        if (fare <= 0 || seats <= 0) {
            System.out.println("Invalid fare or seat count!");
            return;
        }

        if (flightService.searchFlight(id) != null) {
            System.out.println("Flight ID already exists!");
            return;
        }

        Flight flight = new Flight(id, name,
                source, destination, fare, seats);

        flightService.addFlight(flight);
    }
}