public class Student {
    private int id;
    private String name;
    private String course;
    private double fees;

    public Student(String name, String course, double fees) {
        this.name = name;
        this.course = course;
        this.fees = fees;
    }

    public Student(int id, String name, String course, double fees) {
        this.id = id;
        this.name = name;
        this.course = course;
        this.fees = fees;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCourse() {
        return course;
    }

    public double getFees() {
        return fees;
    }
}
