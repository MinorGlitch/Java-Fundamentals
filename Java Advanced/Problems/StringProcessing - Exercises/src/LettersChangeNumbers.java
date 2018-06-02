import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class LettersChangeNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] combinations = reader.readLine().split("\\s+");

        double sum = 0;

        for (String combination : combinations) {
            sum += sumCombination(combination);
        }

        System.out.printf("%.2f", sum);
    }

    private static double sumCombination(String combination) {
        Pattern pattern = Pattern.compile("^([A-Za-z])(\\d+)([A-Za-z])$");

        Matcher matcher = pattern.matcher(combination);

        double sum = 0.0D;

        if (matcher.find()) {
            char start = matcher.group(1).charAt(0);
            double number = Double.valueOf(matcher.group(2));
            char end = matcher.group(3).charAt(0);

            sum += number;

            int position = start % 32;

            if (Character.isUpperCase(start)) {
                sum /= position;
            } else {
                sum *= position;
            }

            position = end % 32;

            if (Character.isUpperCase(end)) {
                sum -= position;
            } else {
                sum += position;
            }
        }

        return sum;
    }
}
