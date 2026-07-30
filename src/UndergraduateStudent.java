public class UndergraduateStudent extends Student implements Reportable  {

    private double gpa;

    public UndergraduateStudent(
            int id,
            String name,
            int age,
            String major,
            double gpa) {

        super(id, name, age, major);
        this.gpa = gpa;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    @Override
    public void displayStudentInfo() {
        System.out.println("ID: " + getId());
        System.out.println("Name: " + getName());
        System.out.println("Age: " + getAge());
        System.out.println("Major: " + getMajor());
        System.out.println("GPA: " + gpa);
    }

    @Override
    public void printReport() {
        System.out.println("Undergraduate Student Report");
        displayStudentInfo();
    }
}