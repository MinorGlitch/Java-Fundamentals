import java.util.Arrays;
import java.util.Scanner;

public class MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] matrixSize = scanner.nextLine().split(" ");

        int rows = Integer.parseInt(matrixSize[0]);
        int cols = Integer.parseInt(matrixSize[1]);

        String[][] matrix = fillMatrix(rows, cols, scanner);

        String command;

        while (true) {
            command = scanner.nextLine();

            if (command.equals("END")) {
                break;
            }

            String[] commandArgs = command.split(" ");

            if (commandArgs.length != 5 || !"swap".equals(commandArgs[0])) {
                System.out.println("Invalid input!");
                continue;
            }

            int row1 = Integer.parseInt(commandArgs[1]);
            int col1 = Integer.parseInt(commandArgs[2]);
            int row2 = Integer.parseInt(commandArgs[3]);
            int col2 = Integer.parseInt(commandArgs[4]);

            try {
                swap(row1, row2, col1, col2, matrix);
                printMatrix(matrix);
            } catch (IndexOutOfBoundsException ex) {
                System.out.println("Invalid input!");
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


    private static void swap(int row1, int row2, int col1, int col2, String[][] matrix) {
        String temp = matrix[row1][col1];
        matrix[row1][col1] = matrix[row2][col2];
        matrix[row2][col2] = temp;
    }

    private static String[][] fillMatrix(int rows, int cols, Scanner scanner) {
        String[][] matrix = new String[rows][cols];

        for (int i = 0; i < matrix.length; i++) {
            String[] row = scanner.nextLine().split(" ");

            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = row[j];
            }
        }

        return matrix;
    }
}
