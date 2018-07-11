package genericArrayCreator;

import java.lang.reflect.Array;

public class ArrayCreator {
    public static <T> T[] create(int length, T item) {
        T[] arr = (T[]) new Object[length];
        addAll(arr, item);

        return arr;
    }

    public static <T> T[] create(Class<T> cl, int length, T item) {
        T[] arr = (T[]) Array.newInstance(cl, length);
        addAll(arr, item);

        return arr;
    }

    private static <T> void addAll(T[] arr, T item) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = item;
        }
    }
}
