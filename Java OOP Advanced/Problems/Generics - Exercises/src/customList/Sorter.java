package customList;

import java.util.stream.Collectors;

public class Sorter {
    public static <T extends Comparable<T>> void sort(CustomList<T> list) {
        list.setElements(list.getElements().stream().sorted().collect(Collectors.toList()));
    }
}
