package genericArrayCreator;

import java.lang.reflect.Array;

public class Main {
    public static void main(String[] args) {
        String[] string = ArrayCreator.create(10, "null");
        Integer[] integers = ArrayCreator.create(Integer.class, 10, 5);


    }
}
