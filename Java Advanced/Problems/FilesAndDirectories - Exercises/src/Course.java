import java.io.Serializable;

public class Course implements Serializable {
    private String name;
    private int students;

    Course(String name, int students) {
        this.name = name;
        this.students = students;
    }

    Course() {
    }

    public int getStudents() {
        return this.students;
    }

    public String getName() {
        return this.name;
    }
}
