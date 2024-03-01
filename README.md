## Hospital-Management-System
This is Java-based Hospital Management System simulates basic functionalities for managing patients, doctors, staff, bed occupancy, billing, and payments. The project is organized into multiple classes, each handling a specific aspect of hospital management.
## Classes:
<ol type="1"ul>
<li><b>Patient:</b>

Collects patient information (name, gender, disease, admission status, age, phone number, ID).
Implemented as a thread to simulate concurrent patient submissions.
</li>

<li><b>Doctor:</b>

Collects doctor information (name, qualification, specialization, availability, ID).
Checks doctor availability for patient assignment.
</li>
<li><b>Hospital:</b>

Manages bed availability.
Provides a synchronized method (occupyBed) for bed assignment.
</li>
<li><b>Staff:</b>

Gathers staff details (ID, name, gender, age, designation, salary).
Implemented as a thread for concurrent staff submissions.
</li>
<li><b>Billing:</b>

Calculates patient bills based on charges (basic, additional, medication, room, doctor's fees).
Displays the bill details.
</li>
<li><b>Payment:</b>

Simulates payment with options for cash, UPI, or NetBanking.
</li>
<li><b>demo:</b>

Main class where program execution begins.
Implements a simple login system.
Allows users to manage patients, doctors, staff, bed occupancy, billing, and payments.</li></ol>

## Usage:
<ol type="1">
<li>Run the program (Hospital_Management.java).</li>
<li>Log in with the predefined username (Itp@123) and password (Tech@123).</li>
<li>Follow the menu to perform various actions within the hospital management system.</li>
</ol>

## Note:
<ul>
  <li>Uses multithreading for concurrent actions (patient and staff submissions).</li>
  <li>Includes basic error handling for user inputs.</li>
  <li>Billing and payment sections implemented as separate threads for asynchronous activities.</li>
</ul>
Feel free to explore and modify the code to suit your needs!

## How to Run:

```bash
#Compile the program
javac Hospital_Management.java

#Run the compiled program
java Hospital_Management
