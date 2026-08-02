public abstract class Student {

    private int id;
    private String name;
    private int age;
    private String major;

    public Student(int id, String name, int age, String major) {
        setId(id);
        setName(name);
        setAge(age);
        setMajor(major);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {

      if (name == null || name.trim().isEmpty()) {
    throw new IllegalArgumentException(
            "Name cannot be empty."
    );
}
        this.name = name;
    }

    public int getAge() {
        return age;
    }

public void setAge(int age) {

    if (age <= 0) {
        throw new IllegalArgumentException(
                "Age must be greater than zero."
        );
    }

    this.age = age;
}
    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public abstract void displayStudentInfo();

    
}