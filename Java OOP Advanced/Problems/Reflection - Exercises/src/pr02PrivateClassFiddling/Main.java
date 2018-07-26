package pr02PrivateClassFiddling;

import pr02PrivateClassFiddling.com.BlackBoxInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class Main {
    private static BlackBoxInt blackBoxInt;

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        blackBoxInt = newBlackBox();

        String command = reader.readLine();

        while (!"END".equals(command)) {
            String[] commandArgs = command.split("_");

            switch (commandArgs[0]) {
                case "add":
                    sum.accept(Integer.valueOf(commandArgs[1]));
                    break;
                case "subtract":
                    subtract.accept(Integer.valueOf(commandArgs[1]));
                    break;
                case "divide":
                    divide.accept(Integer.valueOf(commandArgs[1]));
                    break;
                case "multiply":
                    multiply.accept(Integer.valueOf(commandArgs[1]));
                    break;
                case "leftShift":
                    leftShift.accept(Integer.valueOf(commandArgs[1]));
                    break;
                case "rightShift":
                    rightShift.accept(Integer.valueOf(commandArgs[1]));
                    break;
                default:
                    break;
            }

            System.out.println(getResult.get());

            command = reader.readLine();
        }
    }

    private static Supplier<Integer> getResult = () -> {
        try {
            Field intField = BlackBoxInt.class.getDeclaredFields()[1];
            intField.setAccessible(true);

            return (int) intField.get(blackBoxInt);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return null;
    };

    private static Consumer<Integer> sum = i -> {

        try {
            Method sumMethod = BlackBoxInt.class.getDeclaredMethod("add", int.class);
            sumMethod.setAccessible(true);
            sumMethod.invoke(blackBoxInt, i);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    };

    private static Consumer<Integer> subtract = i -> {
        try {
            Method sumMethod = BlackBoxInt.class.getDeclaredMethod("subtract", int.class);
            sumMethod.setAccessible(true);
            sumMethod.invoke(blackBoxInt, i);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    };

    private static Consumer<Integer> divide = i -> {
        try {
            Method sumMethod = BlackBoxInt.class.getDeclaredMethod("divide", int.class);
            sumMethod.setAccessible(true);
            sumMethod.invoke(blackBoxInt, i);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    };

    private static Consumer<Integer> multiply = i -> {
        try {
            Method sumMethod = BlackBoxInt.class.getDeclaredMethod("multiply", int.class);
            sumMethod.setAccessible(true);
            sumMethod.invoke(blackBoxInt, i);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    };

    private static Consumer<Integer> leftShift = i -> {
        try {
            Method sumMethod = BlackBoxInt.class.getDeclaredMethod("leftShift", int.class);
            sumMethod.setAccessible(true);
            sumMethod.invoke(blackBoxInt, i);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    };

    private static Consumer<Integer> rightShift = i -> {
        try {
            Method sumMethod = BlackBoxInt.class.getDeclaredMethod("rightShift", int.class);
            sumMethod.setAccessible(true);
            sumMethod.invoke(blackBoxInt, i);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    };

    private static BlackBoxInt newBlackBox() throws NoSuchMethodException, IllegalAccessException,
            InvocationTargetException, InstantiationException {

        Constructor<BlackBoxInt> blackBoxIntConstructor = BlackBoxInt.class.getDeclaredConstructor(int.class);
        blackBoxIntConstructor.setAccessible(true);

        return blackBoxIntConstructor.newInstance(0);
    }
}
