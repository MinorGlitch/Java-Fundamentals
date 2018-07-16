package froggy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Lake implements Iterable<Integer> {
    private List<Integer> numbers;

    public Lake(Integer... numbers) {
        this.numbers = new ArrayList<>(Arrays.asList(numbers));
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Frog();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private final class Frog implements Iterator<Integer> {
        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < numbers.size();
        }

        @Override
        public Integer next() {
            return numbers.get(index++);
        }
    }
}
