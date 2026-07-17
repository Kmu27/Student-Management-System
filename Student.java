public class Student {

    int id;
    String name;
    int age;
    String major;

    public Student(int id, String name, int age, String major) {

        this.id = id;
        this.name = name;
        this.age = age;
        this.major = major;
    }

    public void displayStudentInfo() {

        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Major: " + major);
    }
}