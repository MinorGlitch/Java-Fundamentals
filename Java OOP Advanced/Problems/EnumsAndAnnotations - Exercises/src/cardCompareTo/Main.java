package cardCompareTo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Card first = new Card(reader.readLine(), reader.readLine());
        Card second = new Card(reader.readLine(), reader.readLine());

        if (first.compareTo(second) >= 0) {
            System.out.println(first);
        } else {
            System.out.println(second);
        }
    }
}
