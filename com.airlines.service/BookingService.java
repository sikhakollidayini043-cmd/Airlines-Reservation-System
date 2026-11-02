package com.airlines.service;

import java.util.ArrayList;

import com.airlines.model.Booking;
import com.airlines.model.Flight;
import com.airlines.model.Passenger;
import com.airlines.interfaces.Payment;
import com.airlines.util.FileHandler;

public class BookingService {

    private ArrayList<Booking> bookingList;

    private FlightService flightService;

    private final String FILE = "bookings.dat";

    @SuppressWarnings("unchecked")
    public BookingService(FlightService flightService) {

        this.flightService = flightService;

        Object data = FileHandler.loadObject(FILE);

        if (data instanceof ArrayList<?>) {
            bookingList = (ArrayList<Booking>) data;
        } else {
            bookingList = new ArrayList<>();
        }
    }

    public void bookTicket(int bookingId, Passenger passenger,
                           int flightId, Payment payment) {

        Flight flight = flightService.searchFlight(flightId);

        if (flight == null) {
            System.out.println("Flight not found!");
            return;
        }

        if (flight.getAvailableSeats() <= 0) {
            System.out.println("No seats available!");
            return;
        }

        double amount = flight.getFare();

        if (!payment.pay(amount)) {
            System.out.println("Payment failed!");
            return;
        }

        if (flight.bookSeat()) {

            Booking booking = new Booking(
                    bookingId, passenger, flight);

            bookingList.add(booking);

            saveBookings();
            flightService.saveFlights();

            System.out.println("\nTicket booked successfully!");
            System.out.println(booking);
        }
    }

    public void viewBookings() {

        System.out.println("\n========== BOOKING DETAILS ==========");

        if (bookingList.isEmpty()) {
            System.out.println("No bookings found.");
            return;
        }

        for (Booking booking : bookingList) {
            System.out.println(booking);
        }
    }

    public void cancelBooking(int bookingId) {

        for (Booking booking : bookingList) {

            if (booking.getBookingId() == bookingId) {

                Flight flight = flightService.searchFlight(
                        booking.getFlight().getFlightId());

                if (flight != null) {
                    flight.cancelSeat();
                }

                bookingList.remove(booking);
                saveBookings();
                flightService.saveFlights();

                System.out.println("Booking cancelled successfully!");
                return;
            }
        }

        System.out.println("Booking ID not found!");
    }

    public void saveBookings() {
        FileHandler.saveObject(bookingList, FILE);
    }
}