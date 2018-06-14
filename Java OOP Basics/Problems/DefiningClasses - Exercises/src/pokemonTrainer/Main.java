package pokemonTrainer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Trainer> trainers = new LinkedHashMap<>();

        String line = reader.readLine();

        while (!"Tournament".equals(line)) {
            createTrainers(trainers, line);
            line = reader.readLine();
        }

        line = reader.readLine();

        while (!"End".equals(line)) {
            String element = line;

            trainers.values().forEach(t -> {
                if (t.hasPokemonOfType(element)) {
                    t.addBadge();
                } else {
                    t.decreasePokemonsHealth();
                }
            });

            line = reader.readLine();
        }

        printTrainers(trainers.values());
    }

    private static void printTrainers(Collection<Trainer> trainers) {
        trainers.stream().sorted((a, b) -> b.getBadges() - a.getBadges()).forEach(t -> {
            System.out.printf("%s %d %d%n", t.getName(), t.getBadges(), t.getCountOfPokemons());
        });
    }

    private static void createTrainers(Map<String, Trainer> trainers, String line) {
        String[] tokens = line.split(" ");

        String trainerName = tokens[0];
        String pokemonName = tokens[1];
        String pokemonElement = tokens[2];
        int pokemonHealth = Integer.valueOf(tokens[3]);

        trainers.putIfAbsent(trainerName, new Trainer(trainerName));

        Pokemon pokemon = createPokemon(pokemonName, pokemonElement, pokemonHealth);

        trainers.get(trainerName).addPokemon(pokemon);
    }

    private static Pokemon createPokemon(String pokemonName, String pokemonElement, int pokemonHealth) {
        return new Pokemon(pokemonName, pokemonElement, pokemonHealth);
    }
}
