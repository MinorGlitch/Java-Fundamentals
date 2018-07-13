package customList;

import java.util.*;
import java.util.function.Consumer;

public class CustomList<T extends Comparable<T>> implements Iterable<T> {
    private List<T> list;

    public CustomList() {
        this.list = new ArrayList<>();
    }

    public List<T> getElements() {
        return list;
    }

    public void setElements(List<T> list) {
        this.list = list;
    }

    public void add(T element) {
        this.list.add(element);
    }

    public T remove(int index) {
        return list.remove(index);
    }

    public boolean contains(T element) {
        return list.contains(element);
    }

    public void swap(int first, int second) {
        T firstItem = list.get(first);
        T secondItem = list.get(second);

        list.set(first, secondItem);
        list.set(second, firstItem);
    }

    public int countGreaterThan(T element) {
        return (int) this.list.stream().filter(e -> e.compareTo(element) > 0).count();
    }

    public T getMax() {
        return Collections.max(this.list);
    }

    public T getMin() {
        return Collections.min(this.list);
    }

    @Override
    public Iterator<T> iterator() {
        return this.list.iterator();
    }

    @Override
    public void forEach(Consumer<? super T> action) {

    }

    @Override
    public Spliterator<T> spliterator() {
        return null;
    }
}
