package com.airlines.model;

public class Passenger extends User {

    private static final long serialVersionUID = 1L;

    private String phone;

    public Passenger(int userId, String name,
                     String email, String password,
                     String phone) {

        super(userId, name, email, password);
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public void displayDetails() {
        System.out.println("Passenger ID: " + getUserId());
        System.out.println("Name: " + getName());
        System.out.println("Email: " + getEmail());
        System.out.println("Phone: " + phone);
    }
}