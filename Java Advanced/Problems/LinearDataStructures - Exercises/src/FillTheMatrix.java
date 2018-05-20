import java.util.Scanner;

public class FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] arguments = scanner.nextLine().split(", ");

        int matrixSize = Integer.parseInt(arguments[0]);

        String fillAlgorithm = arguments[1];

        int[][] matrix = new int[matrixSize][matrixSize];

        switch (fillAlgorithm) {
            case "A":
                fillSequential(matrix);
                break;
            case "B":
                fillIntersected(matrix);
                break;
        }

        printMatrix(matrix);
    }

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.printf("%d ", matrix[i][j]);
            }

            System.out.println();
        }
    }

    private static void fillSequential(int[][] matrix) {

        int columnCount = 0;

        int fillNumber = 1;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[j][columnCount] = fillNumber++;
            }

            columnCount++;
        }
    }

    private static void fillIntersected(int[][] matrix) {
        int columnCount = 0;

        int fillNumber = 1;

        for (int i = 0; i < matrix.length; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < matrix.length; j++) {
                    matrix[j][columnCount] = fillNumber++;
                }
            } else {
                for (int j = matrix.length - 1; j >= 0; j--) {
                    matrix[j][columnCount] = fillNumber++;
                }
            }

            columnCount++;
        }
    }
}
