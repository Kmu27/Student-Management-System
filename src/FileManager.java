import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileManager {

    public static void saveStudents(
            ArrayList<Student> students) {

        try {

            FileWriter writer =
                    new FileWriter("students.txt");

            for (Student student : students) {

                if (student instanceof GraduateStudent) {

                    GraduateStudent graduate =
                            (GraduateStudent) student;

                    writer.write(
                            "Graduate,"
                                    + graduate.getId() + ","
                                    + graduate.getName() + ","
                                    + graduate.getAge() + ","
                                    + graduate.getMajor() + ","
                                    + graduate.getSupervisor()
                                    + "\n"
                    );

                } else if (student instanceof UndergraduateStudent) {

                    UndergraduateStudent undergraduate =
                            (UndergraduateStudent) student;

                    writer.write(
                            "Undergraduate,"
                                    + undergraduate.getId() + ","
                                    + undergraduate.getName() + ","
                                    + undergraduate.getAge() + ","
                                    + undergraduate.getMajor() + ","
                                    + undergraduate.getGpa()
                                    + "\n"
                    );
                }
            }

            writer.close();

            System.out.println("Students saved successfully.");

        } catch (IOException exception) {

            System.out.println(
                    "Error saving students: "
                            + exception.getMessage()
            );
        }
    }
    public static ArrayList<Student> loadStudents() {

    ArrayList<Student> students = new ArrayList<>();

    File file = new File("students.txt");

    if (!file.exists()) {
        return students;
    }

    try {

        Scanner reader = new Scanner(file);

        while (reader.hasNextLine()) {

            String line = reader.nextLine();

            if (line.trim().isEmpty()) {
                continue;
            }

            String[] data = line.split(",");

            String type = data[0];
            int id = Integer.parseInt(data[1]);
            String name = data[2];
            int age = Integer.parseInt(data[3]);
            String major = data[4];

            if (type.equals("Graduate")) {

                String supervisor = data[5];

                students.add(
                        new GraduateStudent(
                                id,
                                name,
                                age,
                                major,
                                supervisor
                        )
                );

            } else if (type.equals("Undergraduate")) {

                double gpa = Double.parseDouble(data[5]);

                students.add(
                        new UndergraduateStudent(
                                id,
                                name,
                                age,
                                major,
                                gpa
                        )
                );
            }
        }

        reader.close();

        System.out.println("Students loaded successfully.");

    } catch (FileNotFoundException exception) {

        System.out.println(
                "Error loading students: "
                        + exception.getMessage()
        );

    } catch (NumberFormatException exception) {

        System.out.println(
                "Invalid number format in students file."
        );

    } catch (ArrayIndexOutOfBoundsException exception) {

        System.out.println(
                "Invalid student data in students file."
        );
    }

    return students;
}
}