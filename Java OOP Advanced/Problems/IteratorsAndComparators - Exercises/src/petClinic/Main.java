package petClinic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    private static Map<String, Pet> pets = new LinkedHashMap<>();
    private static Map<String, Clinic> clinics = new LinkedHashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.valueOf(reader.readLine());



        for (int i = 0; i < n; i++) {
            String[] commandArgs = reader.readLine().split(" ");

            executeCommand(commandArgs);
        }
    }

    private static void executeCommand(String[] commandArgs) {
        String command = commandArgs[0];

        switch (command) {
            case "Create":
                String type = commandArgs[1];
                switch (type) {
                    case "Pet":
                        pets.put(commandArgs[2], new Pet(commandArgs[2], Integer.valueOf(commandArgs[3]),
                                commandArgs[4]));
                        break;
                    case "Clinic":
                       try {
                           clinics.put(commandArgs[2], new Clinic(Integer.valueOf(commandArgs[3])));
                       } catch (IllegalArgumentException ex) {
                           System.out.println(ex.getMessage());
                       }
                }
                break;
            case "Add":
                try {
                    boolean result = clinics.get(commandArgs[2]).addPet(pets.get(commandArgs[1]));
                    System.out.println(result);
                } catch (IllegalArgumentException ex){
                    System.out.println(ex.getMessage());
                }
                break;
            case "Print":
                if (commandArgs.length == 2) {
                    for (Pet pet : clinics.get(commandArgs[1])) {
                        if (pet == null) {
                            System.out.println("Room empty");
                        } else {
                            System.out.println(pet);
                        }
                    }
                    return;
                }

                System.out.println(clinics.get(commandArgs[1]).getPets()[Integer.valueOf(commandArgs[2]) - 1]);

                break;
            case "HasEmptyRooms":
                System.out.println(clinics.get(commandArgs[1]).hasEmptyRooms());
                break;
            case "Release":
                System.out.println(clinics.get(commandArgs[1]).release());
                break;
        }
    }
}
