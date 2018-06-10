import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Genome {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Pattern pattern = Pattern.compile("(.*?)=(\\d+)--(\\d+)<<([a-z]+)");

        String line = reader.readLine();

        Map<String, Integer> organisms = new LinkedHashMap<>();

        while (!"Stop!".equals(line)) {
            Matcher matcher = pattern.matcher(line);

            if (matcher.find()) {
                String name = getName(matcher.group(1));

                int nameLength = Integer.valueOf(matcher.group(2));

                int genes = Integer.valueOf(matcher.group(3));

                String organismName = matcher.group(4);

                if (name.length() == nameLength && isValidName(name)) {
                    organisms.putIfAbsent(organismName, 0);
                    organisms.put(organismName, organisms.get(organismName) + genes);
                }
            }
            line = reader.readLine();
        }

        organisms = organisms.entrySet().stream()
                .sorted((a, b) -> b.getValue() - a.getValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> a, LinkedHashMap::new));

        for (Map.Entry<String, Integer> organism : organisms.entrySet()) {
            System.out.printf("%s has genome size of %d%n", organism.getKey(), organism.getValue());
        }
    }

    private static boolean isValidName(String name) {
        return name.matches("([a-z]+)");
    }

    private static String getName(String group) {
        String[] name = group.split("[!@#$?]");
        StringBuilder sb = new StringBuilder();

        for (String s : name) {
            if (!s.isEmpty()) {
                sb.append(s);
            }
        }

        return sb.toString();
    }
}
