import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BlurFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long blurAmount = Long.parseLong(scanner.nextLine());

        int rows = scanner.nextInt();
        int cols = scanner.nextInt();

        scanner.nextLine();

        long[][] pixelMatrix = new long[rows][cols];

        for (int i = 0; i < rows; i++) {
            long[] rowArray =
                    Arrays.stream(scanner.nextLine().split("\\s+"))
                            .mapToLong(Long::parseLong).toArray();

            for (int j = 0; j < cols; j++) {
                pixelMatrix[i][j] = rowArray[j];
            }
        }

        int targetRow = scanner.nextInt();
        int targetCol = scanner.nextInt();

        scanner.nextLine();

        int startRow = targetRow - 1 < 0 ? targetRow : targetRow - 1;
        int endRow = targetRow + 1 >= pixelMatrix.length ? targetRow : targetRow + 1;

        int startCol = targetCol - 1 < 0 ? targetCol : targetCol - 1;
        int endCol = targetCol + 1 >= pixelMatrix[targetRow].length ? targetCol : targetCol + 1;

        for (int i = startRow; i <= endRow; i++) {
            for (int j = startCol; j <= endCol; j++) {
                pixelMatrix[i][j] += blurAmount;
            }
        }

        for (long[] matrixRow : pixelMatrix) {

            List<String> matrixLine = new ArrayList<>();

            for (long pixel : matrixRow) {
                matrixLine.add(String.valueOf(pixel));
            }

            System.out.println(String.join(" ", matrixLine));
        }
    }
}
