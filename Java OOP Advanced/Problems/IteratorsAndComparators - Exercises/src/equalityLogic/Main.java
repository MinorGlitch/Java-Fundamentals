package equalityLogic;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Set<Person> first = new TreeSet<>();
        Set<Person> second = new HashSet<>();

        int n = Integer.valueOf(reader.readLine());

        for (int i = 0; i < n; i++) {
            String[] lineArgs = reader.readLine().split(" ");

            Person person = new Person(lineArgs[0], Integer.valueOf(lineArgs[1]));

            first.add(person);
            second.add(person);
        }

        System.out.println(first.size());
        System.out.println(second.size());
    }
}
