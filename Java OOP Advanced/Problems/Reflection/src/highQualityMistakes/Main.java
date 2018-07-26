package highQualityMistakes;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Class<Reflection> reflectionClass = Reflection.class;

        Set<Field> fields = new TreeSet<>(Comparator.comparing(Field::getName));
        Set<Method> getters = new TreeSet<>(Comparator.comparing(Method::getName));
        Set<Method> setters = new TreeSet<>(Comparator.comparing(Method::getName));

        fields.addAll(Arrays.stream(reflectionClass.getDeclaredFields())
                .filter(s -> !Modifier.isPrivate(s.getModifiers())).collect(Collectors.toList()));

        for (Method method : reflectionClass.getDeclaredMethods()) {
            if (method.getName().startsWith("get") && method.getParameterCount() == 0) {
                if (!Modifier.isPublic(method.getModifiers())) {
                    getters.add(method);
                }
            }
            if (method.getName().startsWith("set") && method.getParameterCount() == 1) {
                if (!Modifier.isPrivate(method.getModifiers())) {
                    setters.add(method);
                }
            }
        }

        fields.forEach(f -> System.out.printf("%s must be private!%n", f.getName()));
        getters.forEach(g -> System.out.printf("%s have to be public!%n", g.getName()));
        setters.forEach(s -> System.out.printf("%s have to be private!%n", s.getName()));
    }
}
