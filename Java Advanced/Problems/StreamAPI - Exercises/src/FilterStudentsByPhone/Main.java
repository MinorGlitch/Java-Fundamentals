package FilterStudentsByPhone;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Student> students = new ArrayList<>();

        String line = reader.readLine();

        while (!line.equals("END")) {
            String[] tokens = line.split(" ");

            if (tokens[2].startsWith("02") || tokens[2].startsWith("+3592")) {
                students.add(new Student(tokens[0], tokens[1]));
            }

            line = reader.readLine();
        }

        students.forEach(System.out::println);
    }
}

class Student {
    private String firstName;
    private String lastName;

    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return getFirstName() + " " + getLastName();
    }
}

