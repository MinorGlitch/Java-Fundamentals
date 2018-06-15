package google;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private Company company;
    private Car car;
    private List<Parent> parents;
    private List<Child> children;
    private List<Pokemon> pokemons;

    public Person(String name) {
        this.name = name;
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
        this.pokemons = new ArrayList<>();
    }

    public void addParent(Parent parent) {
        getParents().add(parent);
    }

    public void addChild(Child child) {
        getChildren().add(child);
    }

    public void addPokemon(Pokemon pokemon) {
        getPokemons().add(pokemon);
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public String getName() {
        return name;
    }

    public Company getCompany() {
        return company;
    }

    public Car getCar() {
        return car;
    }

    public List<Parent> getParents() {
        return parents;
    }

    public List<Child> getChildren() {
        return children;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();

        sb.append(getName()).append("\n");
        sb.append("Company:").append("\n");
        if (getCompany() != null) {
            sb.append(getCompany().toString()).append("\n");
        }
        sb.append("Car:").append("\n");
        if (getCar() != null) {
            sb.append(getCar().toString()).append("\n");
        }
        sb.append("Pokemon:").append("\n");
        getPokemons().forEach(p -> sb.append(p.toString()).append("\n"));
        sb.append("Parents:").append("\n");
        getParents().forEach(p -> sb.append(p.toString()).append("\n"));
        sb.append("Children:").append("\n");
        getChildren().forEach(p -> sb.append(p.toString()).append("\n"));

        return sb.toString();
    }
}
