import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ArrayList<Student> students = new ArrayList<>();
        Scanner input = new Scanner(System.in);

        while (true) {

            displayMenu();
            int choice = readInteger(input, "Choose an option: ");

            switch (choice) {

                case 1:
                    addStudent(students, input);
                    break;

                case 2:
                    viewStudents(students);
                    break;

                case 3:
                    searchStudentMenu(students, input);
                    break;

                case 4:
                    updateStudent(students, input);
                    break;

                case 5:
                    deleteStudent(students, input);
                    break;

                case 6:
                    System.out.println("Goodbye!");
                    input.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please choose from 1 to 6.");
            }
        }
    }

    public static void displayMenu() {

        System.out.println("\n===== Student Management System =====");
        System.out.println("1. Add Student");
        System.out.println("2. View Students");
        System.out.println("3. Search Student");
        System.out.println("4. Update Student");
        System.out.println("5. Delete Student");
        System.out.println("6. Exit");
    }

    public static int readInteger(Scanner input, String message) {

        while (true) {

            System.out.print(message);

            if (input.hasNextInt()) {
                int number = input.nextInt();
                input.nextLine();
                return number;
            }

            System.out.println("Invalid input. Please enter a number.");
            input.nextLine();
        }
    }

    public static void addStudent(
            ArrayList<Student> students,
            Scanner input) {

        int id = readInteger(input, "Enter Student ID: ");

        if (isStudentIdExists(students, id)) {
            System.out.println("Student ID already exists.");
            return;
        }

        System.out.print("Enter Student Name: ");
        String name = input.nextLine();

        int age = readInteger(input, "Enter Student Age: ");

        if (age <= 0) {
            System.out.println("Age must be greater than zero.");
            return;
        }

        System.out.print("Enter Student Major: ");
        String major = input.nextLine();

        Student student = new Student(id, name, age, major);
        students.add(student);

        System.out.println("Student added successfully.");
    }

    public static void viewStudents(
            ArrayList<Student> students) {

        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        System.out.println("\n===== Students List =====");

        for (Student student : students) {
            student.displayStudentInfo();
            System.out.println("-------------------------");
        }
    }

    public static Student searchStudent(
            ArrayList<Student> students,
            int id) {

        for (Student student : students) {

            if (student.id == id) {
                return student;
            }
        }

        return null;
    }

    public static void searchStudentMenu(
            ArrayList<Student> students,
            Scanner input) {

        int id = readInteger(input, "Enter Student ID: ");

        Student result = searchStudent(students, id);

        if (result == null) {
            System.out.println("Student not found.");
            return;
        }

        System.out.println("\n===== Student Found =====");
        result.displayStudentInfo();
    }

    public static boolean isStudentIdExists(
            ArrayList<Student> students,
            int id) {

        return searchStudent(students, id) != null;
    }

    public static void updateStudent(
            ArrayList<Student> students,
            Scanner input) {

        int id = readInteger(input, "Enter Student ID: ");

        Student result = searchStudent(students, id);

        if (result == null) {
            System.out.println("Student not found.");
            return;
        }

        System.out.print("Enter New Name: ");
        String newName = input.nextLine();

        int newAge = readInteger(input, "Enter New Age: ");

        if (newAge <= 0) {
            System.out.println("Age must be greater than zero.");
            return;
        }

        System.out.print("Enter New Major: ");
        String newMajor = input.nextLine();

        result.name = newName;
        result.age = newAge;
        result.major = newMajor;

        System.out.println("Student updated successfully.");
    }

    public static void deleteStudent(
            ArrayList<Student> students,
            Scanner input) {

        int id = readInteger(input, "Enter Student ID: ");

        Student result = searchStudent(students, id);

        if (result == null) {
            System.out.println("Student not found.");
            return;
        }

        students.remove(result);

        System.out.println("Student deleted successfully.");
    }
}