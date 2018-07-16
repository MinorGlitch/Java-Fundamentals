package listyIterator;

import java.util.Iterator;

public class ListyIterator implements Iterable<String> {
    private String[] items;
    private int index;

    public ListyIterator() {
    }

    public boolean move() {
        if (!this.hasNext()) {
            return false;
        }

        this.index++;

        return true;
    }

    public boolean hasNext() {
        return this.index + 1 < this.items.length;
    }

    public void print() {
        if (this.items == null || this.items.length == 0) {
            throw new IllegalArgumentException("Invalid Operation!");
        }
        System.out.println(this.items[this.index]);
    }

    public void create(String... names) {
        this.items = names;
    }

    @Override
    public Iterator<String> iterator() {
        return new ListIterator();
    }

    private final class ListIterator implements Iterator<String> {
        private int index;

        @Override
        public boolean hasNext() {
            return index < items.length;
        }

        @Override
        public String next() {
            return ListyIterator.this.items[index++];
        }
    }
}
