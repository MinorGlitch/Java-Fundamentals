package codingTracker;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.*;

public class Tracker {
    @Author(name = "Pesho")
    public static void printMethodsByAuthor(Class<?> cl) {
        Map<String, List<String>> methodsByAuthor = new TreeMap<>();

        Method[] methods = cl.getDeclaredMethods();

        for (Method method : methods) {
            Author author = method.getAnnotation(Author.class);

            if (author == null) {
                continue;
            }

            methodsByAuthor.putIfAbsent(author.name(), new ArrayList<>());

            methodsByAuthor.get(author.name()).add(method.getName() + "()");
        }

        methodsByAuthor.entrySet().forEach(e -> {
            System.out.println(e.getKey() + ": " + String.join(", ", e.getValue()));
        });
    }

    @Author(name = "Pesho")
    public static void main(String[] args) {
        Tracker.printMethodsByAuthor(Tracker.class);
    }
}
