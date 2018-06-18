package salaryIncrease;

import javax.xml.crypto.dom.DOMCryptoContext;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.valueOf(reader.readLine());

        List<Person> people = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] input = reader.readLine().split(" ");
            people.add(new Person(input[0], input[1], Integer.valueOf(input[2]), Double.valueOf(input[3])));
        }

        int bonus = Integer.valueOf(reader.readLine());

        people.forEach(p -> {
            p.increaseSalary(bonus);
            System.out.println(p.toString());
        });
    }
}
