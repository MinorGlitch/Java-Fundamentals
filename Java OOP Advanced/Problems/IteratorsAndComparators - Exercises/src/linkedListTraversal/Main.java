package linkedListTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.valueOf(reader.readLine());

        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();

        for (int i = 0; i < n; i++) {
            String[] lineArgs = reader.readLine().split(" ");

            switch (lineArgs[0]) {
                case "Add":
                    myLinkedList.Add(Integer.valueOf(lineArgs[1]));
                    break;
                case "Remove":
                    myLinkedList.remove(Integer.valueOf(lineArgs[1]));
                    break;
            }
        }

        System.out.println(myLinkedList.size());
        myLinkedList.forEach(s -> System.out.print(s + " "));
    }
}
