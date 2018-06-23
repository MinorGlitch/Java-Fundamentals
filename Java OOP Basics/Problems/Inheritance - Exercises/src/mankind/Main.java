package mankind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] inputArgs = reader.readLine().split("\\s+");

        Student student = null;

        if (inputArgs.length == 3) {
            try {
                student = new Student(inputArgs[0], inputArgs[1], inputArgs[2]);
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
                return;
            }
        }

        inputArgs = reader.readLine().split("\\s+");

        Worker worker;

        try {
            worker = new Worker(inputArgs[0], inputArgs[1], Double.valueOf(inputArgs[2]), Double.valueOf(inputArgs[3]));
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            return;
        }

        System.out.println(student.toString());
        System.out.println(worker.toString());
    }
}
