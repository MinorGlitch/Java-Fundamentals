import java.util.Arrays;
import java.util.Scanner;

public class MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] matrixSize = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        int[][] matrix = fillMatrix(matrixSize, scanner);

        findBestCube(matrix);
    }

    private static void findBestCube(int[][] matrix) {
        int sum = Integer.MIN_VALUE;

        int startRow = 0;
        int startCol = 0;

        for (int row = 0; row < matrix.length - 2; row++) {
            for (int col = 0; col < matrix[row].length - 2; col++) {
                int currentSum = matrix[row][col] + matrix[row][col + 1] + matrix[row][col + 2] +
                        matrix[row + 1][col] + matrix[row + 1][col + 1] + matrix[row + 1][col + 2] +
                        matrix[row + 2][col] + matrix[row + 2][col + 1] + matrix[row + 2][col + 2];

                if (currentSum > sum) {
                    sum = currentSum;
                    startRow = row;
                    startCol = col;
                }
            }
        }

        System.out.println("Sum = " + sum);
        printMatrix(matrix, startRow, startCol);
    }

    private static int[][] fillMatrix(int[] matrixSize, Scanner scanner) {
        int[][] matrix = new int[matrixSize[0]][matrixSize[1]];

        for (int i = 0; i < matrix.length; i++) {
            String[] row = scanner.nextLine().split(" ");

            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = Integer.parseInt(row[j]);
            }
        }

        return matrix;
    }

    private static void printMatrix(int[][] matrix, int row, int col) {
        for (int i = row; i < row + 3; i++) {
            for (int j = col; j < col + 3; j++) {
                System.out.printf("%d ", matrix[i][j]);
            }

            System.out.println();
        }
    }
}
