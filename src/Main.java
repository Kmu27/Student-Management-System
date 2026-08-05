import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

     ArrayList<Student> students =
        FileManager.loadStudents();
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
    FileManager.saveStudents(students);
    System.out.println("Goodbye!");
    input.close();
    return;

                default:
                    System.out.println(
                            "Invalid choice. Please choose from 1 to 6."
                    );
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

    public static int readInteger(
            Scanner input,
            String message) {

        while (true) {

            System.out.print(message);

            String value = input.nextLine().trim();

            try {
                return Integer.parseInt(value);

            } catch (NumberFormatException exception) {

                System.out.println(
                        "Invalid input. Please enter an integer number."
                );
            }
        }
    }

    public static double readDouble(
            Scanner input,
            String message) {

        while (true) {

            System.out.print(message);

            String value = input.nextLine().trim();

            value = value.replace(',', '.');

            try {
                return Double.parseDouble(value);

            } catch (NumberFormatException exception) {

                System.out.println(
                        "Invalid input. Please enter a decimal number."
                );
            }
        }
    }

    public static void addStudent(
            ArrayList<Student> students,
            Scanner input) {

        System.out.println("\n1. Graduate Student");
        System.out.println("2. Undergraduate Student");

        int type = readInteger(
                input,
                "Choose student type: "
        );

        if (type != 1 && type != 2) {
            System.out.println("Invalid student type.");
            return;
        }

        int id = readInteger(
                input,
                "Enter Student ID: "
        );

        if (isStudentIdExists(students, id)) {
            System.out.println("Student ID already exists.");
            return;
        }

        System.out.print("Enter Student Name: ");
        String name = input.nextLine();

        int age = readInteger(
                input,
                "Enter Student Age: "
        );

        System.out.print("Enter Student Major: ");
        String major = input.nextLine();

        try {

            Student student;

            if (type == 1) {

                System.out.print("Enter Supervisor Name: ");
                String supervisor = input.nextLine();

                student = new GraduateStudent(
                        id,
                        name,
                        age,
                        major,
                        supervisor
                );

            } else {

                double gpa = readDouble(
                        input,
                        "Enter GPA: "
                );

                student = new UndergraduateStudent(
                        id,
                        name,
                        age,
                        major,
                        gpa
                );
            }

            students.add(student);
            System.out.println("Student added successfully.");

        } catch (IllegalArgumentException exception) {

            System.out.println(
                    "Student was not added: "
                            + exception.getMessage()
            );
        }
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

            if (student.getId() == id) {
                return student;
            }
        }

        return null;
    }

    public static void searchStudentMenu(
            ArrayList<Student> students,
            Scanner input) {

        int id = readInteger(
                input,
                "Enter Student ID: "
        );

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

        int id = readInteger(
                input,
                "Enter Student ID: "
        );

        Student result = searchStudent(students, id);

        if (result == null) {
            System.out.println("Student not found.");
            return;
        }

        System.out.print("Enter New Name: ");
        String newName = input.nextLine();

        int newAge = readInteger(
                input,
                "Enter New Age: "
        );

        System.out.print("Enter New Major: ");
        String newMajor = input.nextLine();

        try {

            result.setName(newName);
            result.setAge(newAge);
            result.setMajor(newMajor);

            System.out.println("Student updated successfully.");

        } catch (IllegalArgumentException exception) {

            System.out.println(
                    "Student was not updated: "
                            + exception.getMessage()
            );
        }
    }

    public static void deleteStudent(
            ArrayList<Student> students,
            Scanner input) {

        int id = readInteger(
                input,
                "Enter Student ID: "
        );

        Student result = searchStudent(students, id);

        if (result == null) {
            System.out.println("Student not found.");
            return;
        }

        students.remove(result);

        System.out.println("Student deleted successfully.");
    }
}