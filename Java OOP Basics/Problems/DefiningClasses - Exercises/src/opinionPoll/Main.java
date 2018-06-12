package opinionPoll;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Person> people = new ArrayList<>();

        int n = Integer.valueOf(reader.readLine());

        for (int i = 0; i < n; i++) {
            String[] personData = reader.readLine().split(" ");

            people.add(new Person(personData[0], Integer.valueOf(personData[1])));
        }

        people.stream().filter(s -> s.getAge() > 30)
                .sorted((a, b) -> a.getName().compareTo(b.getName()))
                .forEach(s -> System.out.println(s.toString()));
    }
}
