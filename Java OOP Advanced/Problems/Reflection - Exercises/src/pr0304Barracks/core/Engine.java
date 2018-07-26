package pr0304Barracks.core;

import jdk.jshell.spi.ExecutionControl;
import pr0304Barracks.Inject;
import pr0304Barracks.contracts.*;
import pr0304Barracks.contracts.Runnable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Engine implements Runnable {

    private static final String COMMANDS_PACKAGE_NAME =
            "pr0304Barracks.core.commands.";

    private String[] data;
    private Repository repository;
    private UnitFactory unitFactory;

    public Engine(Repository repository, UnitFactory unitFactory) {
        this.repository = repository;
        this.unitFactory = unitFactory;
    }

    @Override
    public void run() {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        while (true) {
            try {
                String input = reader.readLine();
                this.data = input.split("\\s+");
                String commandName = this.data[0];
                String result = interpretCommand(commandName);
                if ("fight".equals(result)) {
                    break;
                }
                if (result != null) {
                    System.out.println(result);
                }
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            } catch (IOException | ExecutionControl.NotImplementedException e) {
                e.printStackTrace();
            }
        }
    }

    private String interpretCommand(String commandName) throws ExecutionControl.NotImplementedException {
        String result = null;
        try {
            Class<?> commandClass = Class.forName(COMMANDS_PACKAGE_NAME + capitalize(commandName) + "Command");
            Constructor<?> commandConstructor = commandClass.
                    getDeclaredConstructor();

            Executable command = (Executable) commandConstructor.newInstance();

            this.inject(command);

            result = command.execute();

        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException |
                InvocationTargetException | InstantiationException e) {
            e.printStackTrace();
        }
        return result;
    }

    private void inject(Executable command) throws IllegalAccessException {
        Class<? extends Executable> commandClass = command.getClass();
        Class<? extends Engine> engineClass = this.getClass();

        for (Field field : commandClass.getDeclaredFields()) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(Inject.class)) {
                field.setAccessible(true);

                for (Field engineField : engineClass.getDeclaredFields()) {
                    engineField.setAccessible(true);
                    if (field.getType().equals(engineField.getType()) &&
                            field.getType().getSimpleName().equals(engineField.getType().getSimpleName())) {
                        field.set(command, engineField.get(this));
                    }
                }
            }
        }
    }

    private String capitalize(String string) {
        return Character.toUpperCase(string.charAt(0)) + string.substring(1).toLowerCase();
    }
}
