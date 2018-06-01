import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MelrahShake {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String text = reader.readLine();
        String pattern = reader.readLine();

        StringBuilder sb = new StringBuilder(text);
        StringBuilder patternSb = new StringBuilder(pattern);
        while (true) {
            int firstIndex = sb.indexOf(pattern);
            int lastIndex = sb.lastIndexOf(pattern);

            if (firstIndex != -1 && lastIndex != -1 && patternSb.length() > 0) {
               sb.replace(lastIndex, patternSb.length() + lastIndex, "");
               sb.replace(firstIndex, patternSb.length() + firstIndex, "");

                System.out.println("Shaked it.");
            } else {
                System.out.println("No shake.");
                System.out.println(sb.toString());
                break;
            }

            if (patternSb.length() > 0) {
                patternSb.deleteCharAt(patternSb.length() / 2);
                pattern = patternSb.toString();
            }
        }


    }
}
