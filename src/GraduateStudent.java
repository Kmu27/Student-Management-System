public class GraduateStudent extends Student {

    private String supervisor;

    public GraduateStudent(int id, String name, int age, String major, String supervisor) {
        super(id, name, age, major);
        this.supervisor = supervisor;
    }
@Override
public void displayStudentInfo() {
    System.out.println("ID: " + getId());
    System.out.println("Name: " + getName());
    System.out.println("Age: " + getAge());
    System.out.println("Major: " + getMajor());
    System.out.println("Supervisor: " + supervisor);
}
}
