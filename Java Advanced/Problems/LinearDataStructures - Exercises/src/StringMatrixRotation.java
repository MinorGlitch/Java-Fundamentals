import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        int startIndex = input.indexOf("(");
        int endIndex = input.indexOf(")");

        int degrees = Integer.parseInt(input.substring(startIndex + 1, endIndex));

        int rotationCount = degrees / 90;

        List<String> inputBuffer = new ArrayList<>();

        int maxLength = 0;

        while (true) {
            input = scanner.nextLine();

            if (input.equals("END")) {
                break;
            }

            inputBuffer.add(input);

            if (input.length() > maxLength) {
                maxLength = input.length();
            }
        }

        int rows = inputBuffer.size();

        char[][] matrix = new char[rows][maxLength];

        fillMatrix(inputBuffer, matrix);

        for (int i = 0; i < rotationCount; i++) {
            matrix = rotateClockwise(matrix);
        }

        printMatrix(matrix);
    }

    private static void printMatrix(char[][] matrix) {
        for (char[] row : matrix) {
            for (char ch : row) {
                System.out.print(ch);
            }

            System.out.println();
        }
    }

    private static void fillMatrix(List<String> inputBuffer, char[][] matrix) {

        for (int i = 0; i < inputBuffer.size(); i++) {
            char[] line = inputBuffer.get(i).toCharArray();

            for (int j = 0; j < matrix[0].length; j++) {

                if (j >= line.length) {
                    matrix[i][j] = ' ';
                } else {
                    matrix[i][j] = line[j];
                }
            }
        }

    }

    private static char[][] rotateClockwise(char[][] matrix) {

        int matrixLength = matrix.length;
        int rowLength = matrix[0].length;

        char[][] rotated = new char[rowLength][matrixLength];

        for (int r = 0; r < matrixLength; r++) {
            for (int c = 0; c < rowLength; c++) {

                rotated[c][matrixLength - 1 - r] = matrix[r][c];
            }
        }

        return rotated;
    }
}
