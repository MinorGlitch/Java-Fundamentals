package pokemonTrainer;

import java.util.ArrayList;
import java.util.List;

public class Trainer {
    private String name;
    private int badges;
    private List<Pokemon> pokemons;

    private static final int BADGES_DEFAULT = 0;

    public Trainer(String name) {
        this.name = name;
        this.badges = BADGES_DEFAULT;
        this.pokemons = new ArrayList<>();
    }

    public int getCountOfPokemons() {
        return this.getPokemons().size();
    }

    public void decreasePokemonsHealth() {
        this.getPokemons().forEach(Pokemon::decreaseHealth);

        this.getPokemons().removeIf(p -> p.getHealth() <= 0);
    }

    public void addPokemon(Pokemon pokemon) {
        this.getPokemons().add(pokemon);
    }

    public void addBadge() {
        this.setBadges(this.getBadges() + 1);
    }

    public String getName() {
        return name;
    }

    public int getBadges() {
        return badges;
    }

    public void setBadges(int badges) {
        this.badges = badges;
    }

    private List<Pokemon> getPokemons() {
        return pokemons;
    }

    public boolean hasPokemonOfType(String type) {
        long pokemons = this.getPokemons().stream().filter(p -> p.getElement().equals(type)).count();

        return pokemons != 0;
    }
}
