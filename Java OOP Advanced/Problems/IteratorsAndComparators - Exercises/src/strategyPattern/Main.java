package strategyPattern;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Set<Person> first = new TreeSet<>(new ComparatorByName());
        Set<Person> second = new TreeSet<>(new ComparatorByAge());

        int n = Integer.valueOf(reader.readLine());

        for (int i = 0; i < n; i++) {
            String[] lineArgs = reader.readLine().split(" ");

            Person person = new Person(lineArgs[0], Integer.valueOf(lineArgs[1]));

            first.add(person);
            second.add(person);
        }

        first.forEach(System.out::println);
        second.forEach(System.out::println);
    }
}
