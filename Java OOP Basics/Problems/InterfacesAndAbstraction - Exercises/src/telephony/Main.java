package telephony;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] phones = reader.readLine().split(" ");
        String[] urls = reader.readLine().split(" ");

        for (String phone : phones) {
            Smartphone smartphone = new Smartphone();

            try {
                System.out.println(smartphone.call(phone));
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }

        }

        for (String url : urls) {
            Smartphone smartphone = new Smartphone();
            try {
                System.out.println(smartphone.browse(url));
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
