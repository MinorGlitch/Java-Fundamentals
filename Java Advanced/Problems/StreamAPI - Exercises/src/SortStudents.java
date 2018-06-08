import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SortStudents {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Student> students = new ArrayList<>();

        String line = reader.readLine();

        while (!line.equals("END")) {
            String[] names = line.split(" ");

            students.add(new Student(names[0], names[1]));

            line = reader.readLine();
        }

        students.stream().sorted((o1, o2) -> {
            int lastNameComparator = o1.getLastName().compareTo(o2.getLastName());

            if (lastNameComparator != 0) {
                return lastNameComparator;
            }

            int firstNameComparator = o2.getFirstName().compareTo(o1.getFirstName());

            return firstNameComparator;
        }).forEach(System.out::println);
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
