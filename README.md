# ✈️ Airlines Reservation System

## 📌 Project Description
The Airlines Reservation System is a Core Java-based console application developed to manage flight details, passenger registration, flight booking, and ticket reservations. It provides separate functionalities for Admin and Passenger users.

The project uses Java Collections and File Handling to store and manage passenger and booking information.

## 🎯 Objectives
- Manage flight details.
- Register and manage passenger information.
- Search and view available flights.
- Book flight tickets.
- Manage passenger bookings.
- Store data using file handling.

## 🛠️ Technologies Used
- Java (Core Java)
- Eclipse IDE
- ArrayList and Collections Framework
- File Handling
- Object Serialization
- OOP Concepts

## 📂 Project Structure
AirlinesReservationSystem
│
└── src
    ├── com.airlines.model
    │   ├── User.java
    │   ├── Passenger.java
    │   ├── Flight.java
    │   └── Booking.java
    │
    ├── com.airlines.service
    │   ├── AdminService.java
    │   ├── FlightService.java
    │   └── BookingService.java
    │
    ├── com.airlines.interfaces
    │   └── Payment.java
    │
    ├── com.airlines.util
    │   └── FileHandler.java
    │
    └── com.airlines.main
        └── AirlinesMain.java

## ⚙️ Main Modules

### 1. Admin Module
- Admin login.
- Add new flights.
- Manage flight details.
- View available flights.

### 2. Passenger Module
- Passenger registration.
- Passenger login.
- Search available flights.
- Book flight tickets.
- View booking details.

## 💡 Java Concepts Used
- Classes and Objects
- Encapsulation
- Inheritance
- Abstraction
- Polymorphism
- Interfaces
- Method Overriding
- ArrayList
- Exception Handling
- File Handling
- Serialization and Deserialization

## 🔄 Project Workflow
```text
Start
  ↓
Main Menu
  ↓
Admin / Passenger
  ↓
Login / Registration
  ↓
Search Flights
  ↓
Select Flight
  ↓
Book Ticket
  ↓
Payment
  ↓
Booking Confirmation
  ↓
Save Data into Files
  ↓
End
```

## ▶️ How to Run the Project
1. Open Eclipse IDE.
2. Create or import the Java project.
3. Make sure all packages and Java files are available.
4. Open `AirlinesMain.java`.
5. Click **Run As → Java Application**.
6. Follow the console menu instructions.

## 💾 Data Storage
The project uses:
- ArrayList for temporary data management.
- File Handling for storing application data.
- Serialization and Deserialization for saving and retrieving objects.

## 🚀 Future Enhancements
- Develop a graphical user interface.
- Integrate a MySQL database.
- Add online payment integration.
- Generate downloadable flight tickets.
- Add email notifications.

## 👩‍💻 Developed By
**Sikhakolli Dayini**

Computer Science and Engineering

## 📌 Conclusion
The Airlines Reservation System demonstrates the practical implementation of Core Java, Object-Oriented Programming, Collections, Exception Handling, and File Handling concepts in a real-world application.
