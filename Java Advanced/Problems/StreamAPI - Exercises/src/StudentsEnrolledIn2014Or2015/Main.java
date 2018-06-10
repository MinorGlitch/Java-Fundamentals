package StudentsEnrolledIn2014Or2015;

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

            List<Integer> grades = tokens.subList(1, tokens.size()).stream()
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            students.add(new Student(tokens.get(0), grades));

            line = reader.readLine();
        }

        Predicate<String> filterByDate = x -> {
            return x.endsWith("14") || x.endsWith("15");
        };

        students.stream().filter(t -> filterByDate.test(t.getFirstName()))
                .forEach(s -> {
                    for (Integer num : s.getGrades()) {
                        System.out.print(num + " ");
                    }
                    System.out.println();
                });
    }
}
class Student {
    private String firstName;
    private List<Integer> grades;

    public Student(String firstName, List<Integer> grades) {
        this.firstName = firstName;
        this.grades = grades;
    }

    public String getFirstName() {
        return firstName;
    }

    public List<Integer> getGrades() {
        return grades;
    }

}
