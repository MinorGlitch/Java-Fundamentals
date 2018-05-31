import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SeriesOfLetters {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();

        int state = 0;

        StringBuilder output = new StringBuilder(input);

        int i = 0;

        while (i < output.length() - 1) {
            switch (state) {
                case 0:
                    if (output.charAt(i) == output.charAt(i + 1)) {
                        output.deleteCharAt(i);
                        state = 0;
                    } else {
                        state = 1;
                    }
                    break;
                case 1:
                    i++;
                    state = 0;
                    break;
            }
        }

        System.out.println(output.toString());
    }
}
