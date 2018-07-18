package petClinic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Clinic implements Iterable<Pet> {
    private int size;
    private Pet[] pets;
    private int index;
    private int iterations;
    private int delta;
    private boolean first;

    public Clinic(int size) {
        this.setSize(size);
        this.pets = new Pet[size];
        index = this.size / 2;
        first = true;
    }

    public boolean addPet(Pet pet) {
        if (pet == null) {
            throw new IllegalArgumentException("Invalid Operation!");
        }

        if (!this.hasEmptyRooms()) {
            return false;
        }

        if (first) {
            this.pets[index] = pet;
            iterations++;
            index -= ++delta;
            first = false;
            return true;
        }

        if (iterations % 2 != 0) {
            this.pets[index] = pet;
            iterations++;
            index += ++delta;
            return true;
        }

        this.pets[index] = pet;
        iterations++;
        index -= ++delta;
        return true;
    }

    public boolean release() {
        for (int i = this.pets.length / 2; i < this.size; i++) {
            if (this.pets[i] != null) {
                this.pets[i] = null;
                return true;
            }
        }

        for (int i = 0; i < this.pets.length / 2; i++) {
            if (this.pets[i] != null) {
                this.pets[i] = null;
                return true;
            }
        }

        return false;
    }

    public boolean hasEmptyRooms() {
        return Arrays.stream(this.pets).anyMatch(s -> s == null);
    }

    private void setSize(int size) {
        if (size % 2 == 0) {
            throw new IllegalArgumentException("Invalid Operation!");
        }

        this.size = size;
    }

    public Pet[] getPets() {
        return pets;
    }

    @Override
    public Iterator<Pet> iterator() {
        return new ClinicIterator();
    }

    private final class ClinicIterator implements Iterator<Pet> {
        private int index = 0;


        @Override
        public boolean hasNext() {
            return index < getPets().length;
        }

        @Override
        public Pet next() {
            return getPets()[index++];
        }
    }
}
