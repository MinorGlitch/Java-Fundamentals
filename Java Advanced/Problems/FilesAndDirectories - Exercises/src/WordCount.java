import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class WordCount {
    public static void main(String[] args) {

        Path wordsPath = Paths.get("./resources/Exercises Resources/words.txt");
        Path textPath = Paths.get("./resources/Exercises Resources/text.txt");

        try (PrintWriter writer = new PrintWriter("./resources/output.txt")) {

            List<String> words = Files.readAllLines(wordsPath);
            List<String> textLines = Files.readAllLines(textPath);

            Map<String, Integer> wordsCount = new HashMap<>();

            for (String word : words) {
                String[] currentWords = word.split(" ");

                for (String currentWord : currentWords) {
                    for (String textLine : textLines) {
                        String[] lineTokens = textLine.split(" ");
                        for (String lineToken : lineTokens) {
                            if (lineToken.equals(currentWord)) {
                                wordsCount.putIfAbsent(currentWord, 0);
                                wordsCount.put(currentWord, wordsCount.get(currentWord) + 1);
                            }
                        }
                    }
                }
            }

            wordsCount = wordsCount.entrySet().stream().sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> a, LinkedHashMap::new));

            for (Map.Entry<String, Integer> wordEntry : wordsCount.entrySet()) {
                writer.printf("%s - %d%n", wordEntry.getKey(), wordEntry.getValue());
            }

            System.out.println();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
