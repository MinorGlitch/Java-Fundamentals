import java.util.Arrays;
import java.util.Scanner;

public class MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] matrixSize = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        String[][] matrix = new String[matrixSize[0]][matrixSize[1]];

        fillSequential(matrix);

        printMatrix(matrix);
    }

    private static void fillSequential(String[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {

                matrix[i][j] = "" + (char) ('a' + i) + (char) ('a' + i + j) + (char) ('a' + i);

            }

        }
    }

    private static void printMatrix(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.printf("%s ", matrix[i][j]);
            }

            System.out.println();
        }
    }

}
