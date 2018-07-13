package customList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        CustomList<String> list = new CustomList<>();

        String line = reader.readLine();

        while (!"END".equals(line)) {
            String[] lineArgs = line.split(" ");

            String command = lineArgs[0];

            dispatchCommand(command, list, Arrays.asList(lineArgs).subList(1, lineArgs.length));

            line = reader.readLine();
        }
    }

    private static void dispatchCommand(String command, CustomList<String> list, List<String> args) {
        switch (command) {
            case "Add":
                list.add(args.get(0));
                break;
            case "Remove":
                int index = Integer.valueOf(args.get(0));
                list.remove(index);
                break;
            case "Contains":
                System.out.println(list.contains(args.get(0)));
                break;
            case "Swap":
                int first = Integer.valueOf(args.get(0));
                int second = Integer.valueOf(args.get(1));
                list.swap(first, second);
                break;
            case "Greater":
                System.out.println(list.countGreaterThan(args.get(0)));
                break;
            case "Max":
                System.out.println(list.getMax());
                break;
            case "Min":
                System.out.println(list.getMin());
                break;
            case "Print":
                for (String s : list) {
                    System.out.println(s);
                }
                break;
            case "Sort":
                Sorter.sort(list);
                break;
        }
    }
}
