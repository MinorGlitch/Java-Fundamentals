package genericCountMethodStrings;

public class Box<T extends Comparable<T>> {
    T item;

    public Box(T item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return item.getClass().getCanonicalName() + ": " + item;
    }
}
