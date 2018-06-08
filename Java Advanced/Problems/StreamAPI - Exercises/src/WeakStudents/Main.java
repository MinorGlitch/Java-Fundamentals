package WeakStudents;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Student> students = new ArrayList<>();

        String line = reader.readLine();

        while (!line.equals("END")) {
            List<String> tokens = Arrays.asList(line.split(" "));

            List<Integer> grades = tokens.subList(2, tokens.size()).stream()
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            students.add(new Student(tokens.get(0), tokens.get(1), grades));

            line = reader.readLine();
        }

        Predicate<List<Integer>> filterByGrade = x -> {
            return x.stream().filter(n -> n <= 3).count() >= 2;
        };

        students.stream().filter(t -> filterByGrade.test(t.getGrades()))
                .forEach(System.out::println);
    }
}

class Student {
    private String firstName;
    private String lastName;
    private List<Integer> grades;

    public Student(String firstName, String lastName, List<Integer> grades) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.grades = grades;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public List<Integer> getGrades() {
        return grades;
    }

    @Override
    public String toString() {
        return getFirstName() + " " + getLastName();
    }
}