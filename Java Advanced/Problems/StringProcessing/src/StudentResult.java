import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;

public class StudentResult {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] line = reader.readLine().split("[- ,]+");

        System.out.println(String.format("%1$-10s|%2$7s|%3$7s|%4$7s|%5$7s|",
                "Name", "JAdv", "JavaOOP", "AdvOOP", "Average"));

        double average = getAverage(Double.valueOf(line[1]), Double.valueOf(line[2]), Double.valueOf(line[3]));

        System.out.println(String.format("%1$-10s|%2$7.2f|%3$7.2f|%4$7.2f|%5$7.4f|",
                line[0], Double.valueOf(line[1]), Double.valueOf(line[2]), Double.valueOf(line[3]), average));
    }

    private static double getAverage(Double num1, Double num2, Double num3) {
        return (num1 + num2 + num3) / 3;
    }
}
