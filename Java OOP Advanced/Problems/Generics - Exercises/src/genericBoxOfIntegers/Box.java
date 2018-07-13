package genericBoxOfIntegers;

public class Box<T> {
    T item;

    public Box(T item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return item.getClass().getCanonicalName() + ": " + item;
    }
}
