import java.util.Scanner;

public class MaximumSumOfSubmatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] matrixSize = scanner.nextLine().split(", ");

        int rows = Integer.valueOf(matrixSize[0]);
        int cols = Integer.valueOf(matrixSize[1]);

        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            String[] row = scanner.nextLine().split(", ");

            for (int j = 0; j < cols; j++) {
                int parsedNum = Integer.valueOf(row[j]);

                matrix[i][j] = parsedNum;
            }
        }

        int bestSum = Integer.MIN_VALUE;
        int startRow = 0;
        int startCol = 0;

        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = 0; j < matrix[i].length - 1; j++) {
                int currentSum = matrix[i][j] + matrix[i][j + 1] + matrix[i + 1][j] + matrix[i + 1][j + 1];

                if (currentSum > bestSum) {
                    bestSum = currentSum;
                    startRow = i;
                    startCol = j;
                }
            }
        }

        System.out.printf("%d %d%n%d %d%n",
                matrix[startRow][startCol],
                matrix[startRow][startCol + 1],
                matrix[startRow + 1][startCol],
                matrix[startRow + 1][startCol + 1]);

        System.out.println(bestSum);
    }
}
