import java.util.ArrayList;
import java.util.Scanner;

class Patient extends Thread {
    String fname, lname, gender, disease, admitstatus;
    int age, id;
    long phone_no;

    public void run() {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Enter the first name of the Patient : ");
            fname = sc.nextLine();
            System.out.println("Enter the last name of the Patient : ");
            lname = sc.nextLine();
            System.out.println("Enter the Gender : ");
            gender = sc.nextLine();
            System.out.println("Enter the disease : ");
            disease = sc.nextLine();
            System.out.println("Enter the Admission Status (Admitted (yes/no)) : ");
            admitstatus = sc.nextLine();
            System.out.print("Enter the id: ");
            id = sc.nextInt();
            System.out.println("Enter the age of the Patient : ");
            age = sc.nextInt();
            // Clear the buffer
            sc.nextLine();
            System.out.println("Enter the Phone No : ");
            phone_no = sc.nextLong();

            System.out.println("Submitting the details.......");
            try {
                Thread.sleep(2000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("Patient's details have been submitted successfully...");
        } catch (Exception e) {

        }
        // finally {
        // // Do not close the Scanner here
        // }
    }
}

class Doctor extends Thread {
    Patient objp = new Patient();
    String d_name;
    String availability, specilization, qualification;
    int id;

    public void run() {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Enter the name of the Doctor assigned : ");
            d_name = sc.nextLine();
            System.out.println("Enter the qualification of " + d_name);
            qualification = sc.nextLine();
            System.out.println("Enter specilization of Mr " + d_name);
            specilization = sc.nextLine();
            // System.out.println("Is Mr "+" d_name "+ "available? (yes/no): ");
            System.out.println("Is Mr." + d_name + " available? (yes/no)");
            availability = sc.nextLine();
            if (availability.equals("yes")) {
                System.out.println("Mr. " + d_name + " is assigned to a patient");
            } else {
                System.out.println("No available doctor. Please check again later.");
            }
        } catch (Exception e) {

        }
        // finally {
        // // Do not close the Scanner here
        // }
    }
}

class Hospital {
    private static long availableBeds = 100;

    public static synchronized void occupyBed() {
        System.out.println("Searching for beds......");
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (availableBeds > 0) {
            availableBeds--;
            System.out.println("Bed occupied. Available beds: " + availableBeds);
        } else {
            System.out.println("No available beds.");
        }
    }

}

class Staff extends Thread {
    int id, salary, age;
    String fname, lname, gen, designation;

    public void run() {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Enter the id: ");
            id = sc.nextInt();

            System.out.print("Enter the First Name: ");
            fname = sc.next();

            System.out.print("Enter the Last Name: ");
            lname = sc.next();

            System.out.print("Enter the Gender: ");
            gen = sc.next();

            System.out.print("Enter the age: ");
            age = sc.nextInt();

            System.out.print("Enter the Designation: ");
            designation = sc.next();

            System.out.print("Enter the Salary: ");
            salary = sc.nextInt();

            // System.out.println("~~~~~~~~~~~~~~~~~~~");
            System.out.println("Submitting the details.......");
            // System.out.println("~~~~~~~~~~~~~~~~~~~");

            try {
                Thread.sleep(2000);
                // System.out.println();
                // System.out.println("Please Go through the details before sbmitting..");
                // System.out.println("~~~~~~~~~~~~~~~~~~~");
                // System.out.println(id + "\t" + fname + " \t" + lname + " \t" + gen + " \t" +
                // age + " \t"
                // + designation + " \t" + salary);
                // System.out.println("~~~~~~~~~~~~~~~~~~~");
                // System.out.println();
                // System.out.println("If it is okay press 1 to proceed...");
                // int x = sc.nextInt();
                Thread.sleep(2000);
                System.out.println();
                // System.out.println("~~~~~~~~~~~~~~~~~~~");

                // if (x == 1) {
                System.out.println("Staff details have been submitted successfully...");
                // System.out.println();
                // } else {
                // System.out.println("Please Enter the correct details");
                // System.out.println();
                // }

            } catch (Exception e) {
                System.out.println(e);
            }
            // System.out.println("~~~~~~~~~~~~~~~~~~~");

        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println();

    }
}

class Billing extends Thread {
    private Patient patient;

    // Constructor to initialize Billing with a Patient object
    public Billing(Patient patient) {
        this.patient = patient;
    }

    public void run() {
        Scanner sc = new Scanner(System.in);
        // Calculate Basic Charges
        double basicCharges; // Example base consultation fee
        System.out.println("Enter the Basic Charges: ");
        basicCharges = sc.nextDouble();

        double additionalCharges; // Additional charges for tests, procedures, etc.
        System.out.println("Enter the Additional Charges for tests, Procedures, etc: ");
        additionalCharges = sc.nextDouble();

        // Medication Charges // Add the cost of each medication
        System.out.println("Enter the Medication Charges: ");
        double medicationCharges = sc.nextDouble();

        // Room Charges (if applicable)
        // Categories of rooms
        /*
         * General Beds / Ward Beds:
         * Private Rooms:
         * Semi-Private Rooms:
         * Intensive Care Unit (ICU) Beds:
         */
        double roomCharges = 0; // Initialize room charges
        System.out.println("Room charges: ");
        int no_of_days;
        System.out.println("Enter number of days Patient stayed in Hospital");
        no_of_days = sc.nextInt();
        String Ward_beds, Private_beds, Semi_Private_beds, ICU;
        System.out.println("Enter 1 for Ward/Beds");
        System.out.println("Enter 2 for Private Rooms");
        System.out.println("Enter 3 for Semi-Private Rooms");
        System.out.println("Enter 4 for ICU");
        System.out.println("Enter the Choice : ");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                roomCharges = 1000 * no_of_days;
                break;

            case 2:
                roomCharges = 6000 * no_of_days;
                break;

            case 3:
                roomCharges = 2500 * no_of_days;
                break;

            case 4:
                roomCharges = 10000 * no_of_days;
                break;
            default:
                System.out.println("Invalid Choice");
        }

        // Doctor's Fees
        double doctorFees; // Include fees for specialists or consulting doctors
        System.out.println("Enter fees for specialists or consulting doctors");
        doctorFees = sc.nextDouble();

        // Total Charges
        double totalCharges = basicCharges + additionalCharges + medicationCharges + roomCharges + doctorFees;
        System.out.println("Displaying bill......");
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Display Invoice
        // System.out.println("Billing Details:");
        // System.out.println("Patient Name: " + patient.fname + " " + patient.lname);
        // System.out.println("Age: " + patient.age);
        // System.out.println("Disease: " + patient.disease);
        // System.out.println("Admission Status: " + patient.admitstatus);
        // System.out.println("Phone Number: " + patient.phone_no);
        // System.out.println("Invoice Number: " + generateInvoice());
        System.out.println("Basic Charges: rupees " + basicCharges);
        System.out.println("Additional Charges: rupees " + additionalCharges);
        System.out.println("Medication Charges: rupees " + medicationCharges);
        System.out.println("Room Charges: rupees " + roomCharges);
        System.out.println("Doctor's Fees: rupees " + doctorFees);
        System.out.println("Total Amount Due: rupees " + totalCharges);
        System.out.println("---------------");
    }
}

class Payment extends Thread {

    public void run() {
        // System.out.println("You have submitted form successfully");
        // System.out.println("Payment is being processed.....");
        System.out.println("Generating Payment Window.........");
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
        }
        System.out.println("Select Payment");
        System.out.println("Enter 1 for cash");
        System.out.println("Enter 2 for UPI");
        System.out.println("Enter 3 for NetBanking");
        Scanner sc = new Scanner(System.in);
        int choice;
        System.out.println("Enter the choice");
        choice = sc.nextInt();
        double amount;

        switch (choice) {

            case 1:
                System.out.println("Enter the amount : ");
                amount = sc.nextDouble();
                try {
                    System.out.println("Payment is being processed.....");
                    Thread.sleep(2000);
                } catch (Exception e) {

                }
                System.out.println("Payment done......");

                break;
            case 2:
                System.out.println("Enter the amount : ");
                amount = sc.nextDouble();
                try {
                    System.out.println("Payment is being processed.....");
                    Thread.sleep(2000);
                } catch (Exception e) {

                }
                System.out.println("Payment done......");

                break;

            case 3:
                System.out.println("Enter the amount : ");
                amount = sc.nextDouble();
                try {
                    System.out.println("Payment is being processed.....");
                    Thread.sleep(2000);
                } catch (Exception e) {

                }
                System.out.println("Payment done......");

                break;
            default:
                System.out.println("Invalid choice");
                break;
        }

    }
}

// class PatientHistory {
// private static ArrayList<Patient> allPatients = new ArrayList<>();
//
// public static void addPatient(Patient patient) {
// allPatients.add(patient);
// }
//
// public static void displayPatientHistory() {
// System.out.println("Patients' Details History:");
// for (Patient p : allPatients) {
// System.out.println("Name: " + p.fname + " " + p.lname);
// System.out.println("Gender: " + p.gender);
// System.out.println("Disease: " + p.disease);
// System.out.println("Admitted?: " + p.admitstatus);
// System.out.println("Age: " + p.age);
// System.out.println("Phone No: " + p.phone_no);
// System.out.println("---------------");
// }
// }
// }

public class Hospital_Management {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // login
        String Systemusername = "Itp@123", Systempassword = "Tech@123";
        String Username, Passward;
        System.out.println("Enter the Username : ");
        Username = sc.nextLine();
        System.out.println("Enter the Passward : ");
        Passward = sc.nextLine();
        if (Username.equals(Systemusername) && Passward.equals(Systempassword)) {

            ArrayList<Patient> patients = new ArrayList<>();
            ArrayList<Doctor> doctors = new ArrayList<>();
            ArrayList<Staff> staffs = new ArrayList<>();
            Patient patient1 = new Patient(); // Create a new Patient object

            System.out.println("Welcome to Hospital Management System!");

            while (true) {
                System.out.println("----------------------------------------------------");
                System.out.println("Enter 1 to add Patient");
                System.out.println("Enter 2 to Assign a doctor to a Patient");
                System.out.println("Enter 3 to view Patient's details");
                System.out.println("Enter 4 to view Doctor's details");
                System.out.println("Enter 5 to add staff details");
                System.out.println("Enter 6 to view staff details");
                System.out.println("Enter 7 to book a bed for Patient");
                System.out.println("Enter 8 to view Bill");
                System.out.println("Enter 9 for Payment (for user only)");
                System.out.println("Enter 10 to Exit");
                System.out.println("----------------------------------------------------");
                System.out.println("Enter your choice: ");
                int choice;
                choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        Patient patient = new Patient();
                        patient.start();
                        try {
                            patient.join(); // Wait for the thread to complete
                            Thread.sleep(1000); // Add a delay for better output
                        } catch (Exception e) {

                        }
                        patients.add(patient);
                        // Clear the buffer
                        sc.nextLine();
                        break;
                    case 2:
                        Doctor doctor = new Doctor();
                        doctor.start();
                        try {
                            doctor.join(); // Wait for the thread to complete
                            Thread.sleep(1000); // Add a delay for better output
                        } catch (Exception e) {

                        }
                        doctors.add(doctor);
                        // Clear the buffer
                        sc.nextLine();
                        break;
                    case 3:
                        // View Patient's details
                        System.out.println("Patients' Details:");
                        for (Patient p : patients) {
                            // disease,admitstatus
                            System.out.println("----------------------------------------------------");
                            System.out.println("id : " + p.id);
                            System.out.println("Name: " + p.fname + " " + p.lname);
                            System.out.println("Gender: " + p.gender);
                            System.out.println("Disease: " + p.disease);
                            System.out.println("Admitted?: " + p.admitstatus);
                            System.out.println("Age: " + p.age);
                            System.out.println("Phone No: " + p.phone_no);
                            System.out.println("----------------------------------------------------");
                        }
                        break;
                    case 4:
                        // View Doctor's details
                        System.out.println("Doctors' Details:");
                        // id specilization,qualification;
                        for (Doctor d : doctors) {
                            // System.out.println("id: " + d.id);
                            System.out.println("----------------------------------------------------");
                            System.out.println("Name: " + d.d_name);
                            System.out.println("Qualifications: " + d.qualification);
                            System.out.println("Specialization: " + d.specilization);
                            System.out.println("Availability: " + d.availability);
                            System.out.println("----------------------------------------------------");
                        }
                        break;
                    case 5:
                        Staff sf = new Staff();
                        sf.start();
                        try {
                            sf.join(); // Wait for the thread to complete
                            Thread.sleep(1000); // Add a delay for better output
                        } catch (Exception e) {

                        }
                        staffs.add(sf);
                        // Clear the buffer
                        sc.nextLine();
                        break;
                    case 6:
                        // int id,salary,age;
                        // String fname,lname,gen,designation;
                        for (Staff d : staffs) {
                            // System.out.println("id: "+d.id);
                            System.out.println("----------------------------------------------------");
                            System.out.println("Id: " + d.id);
                            System.out.println("First Name: " + d.fname);
                            System.out.println("Last Name: " + d.lname);
                            System.out.println("Designation: " + d.designation);
                            System.out.println("Gender: " + d.gen);
                            System.out.println("----------------------------------------------------");
                        }
                        break;
                    case 7:
                        // View Occupy and released beds
                        Hospital.occupyBed();
                        System.out.println();
                        // Hospital.releaseBed();
                        break;

                    case 8:
                        // Assuming you have a Patient object named 'patient' available

                        Billing b = new Billing(patient1); // Pass the Patient object to the Billing constructor
                        b.start();
                        try {
                            b.join(); // Wait for the thread to complete
                            Thread.sleep(2000);
                        } catch (Exception e) {

                        }
                        break;

                    case 9:
                        Payment p = new Payment();
                        p.start();
                        try {
                            p.join(); // Wait for the thread to complete
                            Thread.sleep(1000); // Add a delay for better output
                        } catch (Exception e) {

                        }
                        // Clear the buffer
                        sc.nextLine();
                        break;

                    case 10:
                        System.out.println("----------------------------------------------------");
                        System.out.println("Thank you for using our service...");
                        System.exit(0);
                        System.out.println("----------------------------------------------------");
                        break;
                    default:
                        System.out.println("Invalid Input");
                        break;
                }

            }
        } else {
            System.out.println("Enter valid username or Passward");
        }
    }
}
