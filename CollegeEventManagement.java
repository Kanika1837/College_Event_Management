import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private int studentId;
    private String studentName;
    private String department;

    public Student(int studentId, String studentName, String department) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.department = department;
    }

    @Override
    public String toString() {
        return "Student ID: " + studentId +
                ", Name: " + studentName +
                ", Department: " + department;
    }
}

class Event {
    private int eventId;
    private String eventName;
    private String eventDate;
    private String venue;

    private ArrayList<Student> students;

    public Event(int eventId, String eventName, String eventDate, String venue) {
        this.eventId = eventId;
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.venue = venue;
        students = new ArrayList<>();
    }

    public int getEventId() {
        return eventId;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void displayEvent() {
        System.out.println("------------------------------------");
        System.out.println("Event ID   : " + eventId);
        System.out.println("Event Name : " + eventName);
        System.out.println("Date       : " + eventDate);
        System.out.println("Venue      : " + venue);
    }

    public void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No students registered.");
        } else {
            System.out.println("\nRegistered Students:");
            for (Student s : students) {
                System.out.println(s);
            }
        }
    }
}

public class CollegeEventManagement {

    static ArrayList<Event> events = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n===================================");
            System.out.println(" COLLEGE EVENT MANAGEMENT SYSTEM");
            System.out.println("===================================");
            System.out.println("1. Add Event");
            System.out.println("2. View Events");
            System.out.println("3. Register Student");
            System.out.println("4. View Registered Students");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addEvent();
                    break;

                case 2:
                    viewEvents();
                    break;

                case 3:
                    registerStudent();
                    break;

                case 4:
                    viewRegisteredStudents();
                    break;

                case 5:
                    System.out.println("Thank you for using the system.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 5);

        sc.close();
    }

    static void addEvent() {

        System.out.print("Enter Event ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Event Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Event Date: ");
        String date = sc.nextLine();

        System.out.print("Enter Venue: ");
        String venue = sc.nextLine();

        events.add(new Event(id, name, date, venue));

        System.out.println("Event Added Successfully.");
    }

    static void viewEvents() {

        if (events.isEmpty()) {
            System.out.println("No events available.");
            return;
        }

        for (Event e : events) {
            e.displayEvent();
        }
    }

    static Event searchEvent(int id) {

        for (Event e : events) {
            if (e.getEventId() == id) {
                return e;
            }
        }

        return null;
    }

    static void registerStudent() {

        System.out.print("Enter Event ID: ");
        int eventId = sc.nextInt();

        Event event = searchEvent(eventId);

        if (event == null) {
            System.out.println("Event Not Found.");
            return;
        }

        System.out.print("Enter Student ID: ");
        int sid = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Student Name: ");
        String sname = sc.nextLine();

        System.out.print("Enter Department: ");
        String dept = sc.nextLine();

        Student student = new Student(sid, sname, dept);

        event.addStudent(student);

        System.out.println("Student Registered Successfully.");
    }

    static void viewRegisteredStudents() {

        System.out.print("Enter Event ID: ");
        int id = sc.nextInt();

        Event event = searchEvent(id);

        if (event == null) {
            System.out.println("Event Not Found.");
            return;
        }

        event.displayStudents();
    }
}