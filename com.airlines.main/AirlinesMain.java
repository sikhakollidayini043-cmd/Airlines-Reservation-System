//**** Airlines Reservation System ****
package com.airlines.main;

import java.util.Scanner;

import com.airlines.model.Passenger;
import com.airlines.service.FlightService;
import com.airlines.service.BookingService;
import com.airlines.service.AdminService;
import com.airlines.interfaces.Payment;

public class AirlinesMain {

    private static final  Scanner sc = new Scanner(System.in);

    private static FlightService flightService = new FlightService();

    private static BookingService bookingService = new BookingService(flightService);

    private static AdminService adminService = new AdminService(flightService);

    static int bookingId = 1001;
    static int passengerId = 501;

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n======================================");
            System.out.println("AIRLINES RESERVATION SYSTEM");
            System.out.println("======================================");
            System.out.println("1. View Flights");
            System.out.println("2. Book Ticket");
            System.out.println("3. View Bookings");
            System.out.println("4. Cancel Booking");
            System.out.println("5. Admin Login");
            System.out.println("6. Exit");
            System.out.println("======================================");

            choice = readInt("Enter your choice: ");

            switch (choice) {

                case 1:
                    flightService.viewFlights();
                    break;

                case 2:
                    bookTicket();
                    break;

                case 3:
                    bookingService.viewBookings();
                    break;

                case 4:
                    int id = readInt("Enter Booking ID: ");
                    bookingService.cancelBooking(id);
                    break;

                case 5:
                    adminLogin();
                    break;

                case 6:
                    System.out.println("Thank you for using Airlines Reservation System!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 6);

        sc.close();
    }

    public static void bookTicket() {

        try {
            System.out.println("\n========== PASSENGER DETAILS ==========");

            System.out.print("Enter Passenger Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Email: ");
            String email = sc.nextLine();

            System.out.print("Enter Password: ");
            String password = sc.nextLine();

            System.out.print("Enter Phone Number: ");
            String phone = sc.nextLine();

            Passenger passenger = new Passenger(
                    passengerId++, name, email, password, phone);

            flightService.viewFlights();

            int flightId = readInt("Enter Flight ID: ");

            System.out.println("\n1. UPI Payment");
            System.out.println("2. Card Payment");

            int paymentChoice = readInt("Select Payment Method: ");

            Payment payment;

            if (paymentChoice == 1) {

                System.out.print("Enter UPI ID: ");
                String upi = sc.nextLine();

                payment = amount -> {
                    if (upi.contains("@") && upi.length() > 3) {
                        System.out.println(
                                "UPI payment successful: Rs." + amount);
                        return true;
                    }

                    System.out.println("Invalid UPI ID!");
                    return false;
                };

            } else if (paymentChoice == 2) {

                System.out.print("Enter Card Number: ");
                String card = sc.nextLine();

                payment = amount -> {
                    if (card.matches("\\d{16}")) {
                        System.out.println(
                                "Card payment successful: Rs." + amount);
                        return true;
                    }

                    System.out.println("Invalid card number!");
                    return false;
                };

            } else {
                System.out.println("Invalid payment method!");
                return;
            }

            bookingService.bookTicket(bookingId++, passenger, flightId, payment);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void adminLogin() {

        System.out.println("\n========== ADMIN LOGIN ==========");

        System.out.print("Enter Email: ");
        String email = sc.nextLine();

        System.out.print("Enter Password: ");
        String password = sc.nextLine();

        if (adminService.login(email, password)) {

            System.out.println("Admin Login Successful!");

            System.out.println("\n========== ADD NEW FLIGHT ==========");

            int id = readInt("Enter Flight ID: ");

            System.out.print("Enter Flight Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Source: ");
            String source = sc.nextLine();

            System.out.print("Enter Destination: ");
            String destination = sc.nextLine();

            double fare = readDouble("Enter Ticket Fare: ");

            int seats = readInt("Enter Available Seats: ");

            adminService.addFlight(id, name,
                    source, destination, fare, seats);

        } else {
            System.out.println("Invalid Admin Credentials!");
        }
    }

    public static int readInt(String message) {

        while (true) {
            try {
                System.out.print(message);
                return Integer.parseInt(sc.nextLine().trim());

            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number!");
            }
        }
    }

    public static double readDouble(String message) {

        while (true) {
            try {
                System.out.print(message);
                return Double.parseDouble(sc.nextLine().trim());

            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid amount!");
            }
        }
    }
}