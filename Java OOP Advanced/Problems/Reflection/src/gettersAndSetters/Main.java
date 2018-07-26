package gettersAndSetters;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Method[] methods = Reflection.class.getDeclaredMethods();

        Set<Method> getters = new TreeSet<>(Comparator.comparing(Method::getName));
        Set<Method> setters = new TreeSet<>(Comparator.comparing(Method::getName));

        for (Method method : methods) {
            if (method.getName().startsWith("get") && method.getParameterCount() == 0) {
                getters.add(method);
            } else if (method.getName().startsWith("set") && method.getParameterCount() >= 1) {
                setters.add(method);
            }
        }

        getters.forEach(g -> System.out.println(String.format("%s will return %s", g.getName(), g.getReturnType())));
        setters.forEach(s -> System.out.println(String.format("%s and will set field of %s", s.getName(),
                s.getParameterTypes()[0])));
    }
}
