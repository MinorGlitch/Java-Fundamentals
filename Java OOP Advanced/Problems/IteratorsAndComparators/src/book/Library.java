package book;

import java.util.Iterator;

public class Library<T> implements Iterable<T> {
    private T[] items;

    public Library(T... items) {
        this.items = items;
    }

    @Override
    public Iterator<T> iterator() {
        return new LibIterator();
    }

    private final class LibIterator implements Iterator<T> {
        private int counter = 0;

        @Override
        public boolean hasNext() {
            return counter < items.length;
        }

        @Override
        public T next() {
            return items[counter++];
        }
    }
}
