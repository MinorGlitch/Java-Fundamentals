import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class SumBigNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String firstNumber = reader.readLine();
        String secondNumber = reader.readLine();

        if (firstNumber.length() > secondNumber.length()) {
            secondNumber = String.format("%1$" + firstNumber.length() + "s", secondNumber).replace(' ', '0');
        } else {
            firstNumber = String.format("%1$" + secondNumber.length() + "s", firstNumber).replace(' ', '0');
        }

        StringBuilder sb = new StringBuilder();

        int remainder = 0;

        for (int i = firstNumber.length() - 1; i >= 0 ; i--) {

            int sum = firstNumber.charAt(i) - 48 + secondNumber.charAt(i) - 48 + remainder;

            int number = sum % 10;

            remainder = sum / 10;

            sb.append(number);

            if (i == 0 && remainder > 0)
            {
                sb.append(remainder);
            }
        }

        char[] output = sb.toString().replaceAll("0+$", "").toCharArray();

        for (int i = output.length - 1; i >= 0; i--) {
            char c = output[i];


            System.out.print(c);
        }
    }

}
