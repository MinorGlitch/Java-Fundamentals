package P04_DetailPrinter;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        DetailsPrinter detailsPrinter = new DetailsPrinter(new ArrayList<>() {{
            add(new Employee("Employee"));
            add(new Manager("Manager", new ArrayList<String>() {{
                add("Doc1");
                add("Doc2");
                add("Doc3");
            }}));
        }});

        detailsPrinter.printDetails();
    }
}
