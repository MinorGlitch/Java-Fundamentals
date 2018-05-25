import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class SrbskoUnleashed {
    private static Map<String, Map<String, Long>> concerts = new LinkedHashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Pattern pattern = Pattern.compile("(([a-zA-Z]+\\s){1,3})@(([a-zA-Z]+\\s){1,3})(\\d+)\\s(\\d+)");

        String line = scanner.nextLine();

        while (!line.equals("End")) {
            Matcher m = pattern.matcher(line);

            if (m.find()) {
                String name = m.group(1).trim();
                String venue = m.group(3).trim();

                long ticketPrice = Integer.parseInt(m.group(5));
                long ticketsCount = Integer.parseInt(m.group(6));

                long income = ticketPrice * ticketsCount;

                concerts.putIfAbsent(venue, new LinkedHashMap<>());
                concerts.get(venue).putIfAbsent(name, 0L);

                concerts.get(venue).put(name, concerts.get(venue).get(name) + income);
            }

            line = scanner.nextLine();
        }

        for (Map.Entry<String, Map<String, Long>> concertEntry : concerts.entrySet()) {
            System.out.println(concertEntry.getKey());
            Map<String, Long> sortedSingers = concertEntry.getValue().entrySet()
                    .stream().sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                    .collect(Collectors.toMap(Map.Entry::getKey,
                            Map.Entry::getValue, (a, b) -> a, LinkedHashMap::new));

            for (Map.Entry<String, Long> singerEntry : sortedSingers.entrySet()) {
                System.out.printf("#  %s -> %d%n", singerEntry.getKey() , singerEntry.getValue());
            }
        }

        System.out.println();
    }

}
