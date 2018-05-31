import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MagicExchangeableWords {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] words = reader.readLine().split(" ");

        List<Character> firstWord = words[0].chars().mapToObj(c -> (char) c).collect(Collectors.toList());
        List<Character> secondWord = words[1].chars().mapToObj(c -> (char) c).collect(Collectors.toList());

       firstWord = firstWord.stream().distinct().collect(Collectors.toList());
       secondWord = secondWord.stream().distinct().collect(Collectors.toList());

       if (firstWord.size() == secondWord.size()) {
           System.out.println(true);
       } else {
           System.out.println(false);
       }
    }
}
