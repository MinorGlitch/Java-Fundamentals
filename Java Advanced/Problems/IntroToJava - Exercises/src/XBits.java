import java.util.Scanner;

public class XBits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] matrix = new int[8][32];

        for (int i = 0; i < matrix.length; i++) {
            int currentNumber = Integer.parseInt(scanner.nextLine());

            char[] binaryNum = Integer.toBinaryString(currentNumber).toCharArray();

            for (int j = 0; j < binaryNum.length; j++) {
                int startPos = matrix[i].length - binaryNum.length;
                int index = startPos + j;

                matrix[i][index] = Integer.parseInt(String.valueOf(binaryNum[j]));
            }
        }

        int xBitsCount = 0;

        for (int row = 0; row < matrix.length - 2; row++) {
            for (int col = 0; col < matrix[row].length - 2; col++) {
                if (matrix[row][col] == 1 && isValidXBit(matrix, row, col)) {
                    xBitsCount++;
                }
            }
        }

        System.out.println(xBitsCount);
    }

    private static boolean isValidXBit(int[][] matrix, int row, int col) {
        int[] pattern = new int[]{1, 0, 1, 0, 1, 0, 1, 0, 1};

        int patternIndex = 0;

        for (int i = row; i < row + 3; i++) {
            for (int j = col; j < col + 3; j++) {
                if (matrix[i][j] != pattern[patternIndex++]) {
                    return false;
                }
            }
        }

        return true;
    }
}
