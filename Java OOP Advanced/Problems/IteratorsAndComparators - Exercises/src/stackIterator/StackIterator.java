package stackIterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class StackIterator<T> implements Iterable<T> {
    private List<T> items;

    public StackIterator() {
        this.items = new ArrayList<>();
    }

    public void push(T... items) {
        this.items.addAll(Arrays.asList(items));
    }

    public void pop() {
        if (this.items.isEmpty()) {
            System.out.println("No elements");
            return;
        }

        this.items.remove(items.size() - 1);
    }

    @Override
    public Iterator<T> iterator() {
        return new StIterator();
    }

    private final class StIterator implements Iterator<T> {
        private int index = items.size() - 1;


        @Override
        public boolean hasNext() {
            return index >= 0;
        }

        @Override
        public T next() {
            return items.get(this.index--);
        }
    }
}
