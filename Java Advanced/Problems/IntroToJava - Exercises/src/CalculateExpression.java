import java.util.Scanner;

public class CalculateExpression {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();

        double f1Result = function1(a, b, c);
        double f2Result = function2(a, b, c);
        double averageResult = absoluteDiff(a, b, c, f1Result, f2Result);

        System.out.printf("F1 result: %.2f; F2 result: %.2f; Diff: %.2f", f1Result, f2Result, averageResult);
    }

    private static double function1(double a, double b, double c) {
        double power = (a + b + c) / Math.sqrt(c);

        return Math.pow((a * a + b * b) / (a * a - b * b), power);
    }

    private static double function2(double a, double b, double c) {
        double power = (a - b);

        return Math.pow((a * a + b * b - c * c * c), power);
    }

    private static double absoluteDiff(double a, double b, double c, double f1, double f2) {
        double average = average(a, b, c) - average(f1, f2);

        return Math.abs(average);
    }

    private static double average(double a, double b, double c) {
        return (a + b + c) / 3;
    }

    private static double average(double f1, double f2) {
        return (f1 + f2) / 2;
    }
}
