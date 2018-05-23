import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, double[]> students = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String studentName = scanner.nextLine();
            double[] grades = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToDouble(Double::parseDouble).toArray();

            students.put(studentName, grades);
        }
        printStudents(students);
    }

    private static void printStudents(Map<String, double[]> students) {
        for (Map.Entry<String, double[]> studentSet : students.entrySet()) {
            System.out.printf("%s is graduated with %s%n", studentSet.getKey(),
                    getAverageGrade(studentSet.getValue()));
        }
    }

    private static double getAverageGrade(double[] value) {
        int count = value.length;

        double sum = 0.0D;

        for (double grade : value) {
            sum += grade;
        }

        return sum / count;
    }
}
