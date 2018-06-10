import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Ranking {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Map<String, Integer>> rankings = new LinkedHashMap<>();

        String line = reader.readLine();

        List<String[]> contests = new ArrayList<>();

        while (!"end of contests".equals(line)) {
            contests.add(line.split(":"));

            line = reader.readLine();
        }

        line = reader.readLine();

        List<String[]> submissions = new ArrayList<>();

        while (!"end of submissions".equals(line)) {
            submissions.add(line.split("=>"));

            line = reader.readLine();
        }

        for (String[] submission : submissions) {
            for (String[] contest : contests) {
                String contestName = contest[0];
                String submissionName = submission[0];
                String contestPass = contest[1];
                String submissionPass = submission[1];

                if (contestName.equals(submissionName) && contestPass.equals(submissionPass)) {
                    String userNameSub = submission[2];
                    rankings.putIfAbsent(userNameSub, new LinkedHashMap<>());
                    rankings.get(userNameSub).putIfAbsent(contest[0], 0);
                    int personScore = rankings.get(userNameSub).get(contest[0]);
                    int currentScore = Integer.valueOf(submission[3]);

                    if (currentScore > personScore) {
                        rankings.get(userNameSub).put(contestName, currentScore);
                    }
                }
            }
        }

        rankings.entrySet().stream().sorted((a, b) -> {
            int aSum = a.getValue().entrySet().stream().mapToInt(Map.Entry::getValue).sum();
            int bSum = b.getValue().entrySet().stream().mapToInt(Map.Entry::getValue).sum();

            return bSum - aSum;
        }).limit(1).forEach(s -> {
            int sum = s.getValue().entrySet().stream().mapToInt(Map.Entry::getValue).sum();

            System.out.printf("Best candidate is %s with total %d points.%n", s.getKey(), sum);
        });
        System.out.println("Ranking:");
        rankings.entrySet().stream().sorted(Comparator.comparing(Map.Entry::getKey)).forEach(a -> {
            System.out.println(a.getKey());
            a.getValue().entrySet().stream().sorted((a1, b) -> b.getValue() - a1.getValue()).forEach(n -> {
                System.out.printf("#  %s -> %d%n", n.getKey(), n.getValue());
            });
        });
    }
}
