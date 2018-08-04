package P01_ExtendedArrayList;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        ExtendedArrayList<Integer> extendedArrayList = new ExtendedArrayList<>();

        Collections.addAll(extendedArrayList, 7, 15, 8, 8, 222, 999, 222);

        int min = extendedArrayList.min();
        int max = extendedArrayList.max();

        System.out.println(min);
        System.out.println(max);
    }
}
