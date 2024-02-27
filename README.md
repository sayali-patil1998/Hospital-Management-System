# Hospital-Management-System
This Java-based Hospital Management System simulates basic functionalities for managing patients, doctors, staff, bed occupancy, billing, and payments. The project is organized into multiple classes, each handling a specific aspect of hospital management.
# Classes:
<ul>Patient:

Collects patient information (name, gender, disease, admission status, age, phone number, ID).
Implemented as a thread to simulate concurrent patient submissions.
</ul>
Doctor:

Collects doctor information (name, qualification, specialization, availability, ID).
Checks doctor availability for patient assignment.
Hospital:

Manages bed availability.
Provides a synchronized method (occupyBed) for bed assignment.
Staff:

Gathers staff details (ID, name, gender, age, designation, salary).
Implemented as a thread for concurrent staff submissions.
Billing:

Calculates patient bills based on charges (basic, additional, medication, room, doctor's fees).
Displays the bill details.
Payment:

Simulates payment with options for cash, UPI, or NetBanking.
demo:

Main class where program execution begins.
Implements a simple login system.
Allows users to manage patients, doctors, staff, bed occupancy, billing, and payments.
