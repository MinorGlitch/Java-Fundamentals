import java.util.Scanner;

public class RectangleArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double a = scanner.nextDouble();
        double b = scanner.nextDouble();

        double area = calculateArea(a, b);

        System.out.printf("%.2f%n", area);
    }

    private static double calculateArea(double a, double b) {
        return a * b;
    }
}
