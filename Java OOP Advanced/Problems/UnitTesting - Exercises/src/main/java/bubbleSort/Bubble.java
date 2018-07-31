package bubbleSort;

import java.util.List;

public class Bubble {

    public void sort(List<Integer> list) {
        int n = list.size();
        boolean swapped = true;

        while (swapped) {
            swapped = false;
            for (int i = 1; i <= n - 1; i++) {
                if (list.get(i - 1) > list.get(i)) {
                    this.swap(list, i - 1, i);
                    swapped = true;
                }
            }
        }
    }

    private void swap(List<Integer> list, int origin, int target) {
        int temp = list.get(target);

        list.set(target, list.get(origin));

        list.set(origin, temp);
    }
}
