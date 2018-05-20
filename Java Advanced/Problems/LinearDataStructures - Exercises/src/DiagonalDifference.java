import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int[][] matrix = fillMatrix(n, scanner);

        int diagonalsSum = sumDiagonals(matrix);

        System.out.println(diagonalsSum);
    }

    private static int[][] fillMatrix(int n, Scanner scanner) {
        int[][] matrix = new int[n][n];

        for (int i = 0; i < matrix.length; i++) {
            String[] row = scanner.nextLine().split(" ");

            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = Integer.parseInt(row[j]);
            }
        }

        return matrix;
    }

    private static int sumDiagonals(int[][] matrix) {
        int leftDiagonal = getLeftDiagonal(matrix);
        int rightDiagonal = getRightDiagonal(matrix);

        return Math.abs(leftDiagonal - rightDiagonal);
    }

    private static int getLeftDiagonal(int[][] matrix) {
        int total = 0;

        for (int row = 0; row < matrix.length; row++) {

            total += matrix[row][row];
        }

        return total;
    }

    private static int getRightDiagonal(int[][] matrix) {
        int total = 0;

        for (int row = 0; row < matrix.length; row++) {

            total += matrix[row][matrix[row].length - 1 - row];
        }

        return total;
    }
}
