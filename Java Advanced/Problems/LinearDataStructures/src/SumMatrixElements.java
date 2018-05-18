import java.util.Scanner;

public class SumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] matrixSize = scanner.nextLine().split(", ");

        int rows = Integer.valueOf(matrixSize[0]);
        int cols = Integer.valueOf(matrixSize[1]);

        int[][] matrix = new int[rows][cols];

        int sum = 0;

        for (int i = 0; i < rows; i++) {
            String[] row = scanner.nextLine().split(", ");

            for (int j = 0; j < cols; j++) {
                int parsedNum = Integer.valueOf(row[j]);

                matrix[i][j] = parsedNum;
                sum+= parsedNum;
            }
        }

        System.out.println(matrix.length);
        System.out.println(matrix[0].length);
        System.out.println(sum);
    }
}
