package classBoxDataValidation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        double[] boxParameters = new double[3];

        for (int i = 0; i < 3; i++) {
            boxParameters[i] = Double.valueOf(reader.readLine());
        }

        Box box;

        try {
            box = new Box(boxParameters[0], boxParameters[1], boxParameters[2]);
            System.out.printf("Surface Area - %.2f%n", box.calculateSurfaceArea());
            System.out.printf("Lateral Surface Area - %.2f%n", box.calculateLateralSurfaceArea());
            System.out.printf("Volume - %.2f", box.calculateVolume());
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
