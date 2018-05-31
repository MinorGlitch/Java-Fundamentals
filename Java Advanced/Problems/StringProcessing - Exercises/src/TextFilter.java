import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TextFilter {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] bannedWords = reader.readLine().split(", ");

        String text = reader.readLine();

        for (String bannedWord : bannedWords) {
            if (text.contains(bannedWord)) {
                text = text.replaceAll(bannedWord, repeatStr("*", bannedWord.length()));
            }
        }

        System.out.println(text);
    }

    private static String repeatStr(String strToRepeat, int count) {
        StringBuilder character = new StringBuilder();

        for (int i = 0; i < count; i++) {
            character.append(strToRepeat);
        }
        return character.toString();
    }
}
