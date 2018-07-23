package infernoInfinity.dispatchers;

import infernoInfinity.annotations.CustomAnnotation;
import infernoInfinity.factories.GemFactory;
import infernoInfinity.Weapon;
import infernoInfinity.repositories.WeaponRepository;
import infernoInfinity.factories.WeaponFactory;

public class CommandDispatcher {
    public static void dispatchCommand(String[] args, WeaponRepository repository) {
        switch (args[0]) {
            case "Create":
                createWeapon(args[1], args[2], repository);
                break;
            case "Add":
                addGem(args[1], Integer.valueOf(args[2]), args[3], repository);
                break;
            case "Remove":
                removeGem(args[1], Integer.valueOf(args[2]), repository);
                break;
            case "Print":
                printWeapon(args[1], repository);
                break;
            case "Compare":
                compareWeapons(args[1], args[2], repository);
                break;
            default:
                getAnnotationInfo(args[0]);
                break;
        }
    }

    private static void getAnnotationInfo(String type) {
        CustomAnnotation annotation = Weapon.class.getAnnotation(CustomAnnotation.class);

        switch (type) {
            case "Author":
                System.out.println(String.format("Author: %s", annotation.author()));
                break;
            case "Revision":
                System.out.println(String.format("Revision: %s", annotation.revision()));
                break;
            case "Description":
                System.out.println(String.format("Class description: %s", annotation.description()));
                break;
            case "Reviewers":
                System.out.println(String.format("Reviewers: %s", String.join(", ", annotation.reviewers())));
        }
    }

    private static void compareWeapons(String first, String second, WeaponRepository repository) {
        Weapon firstWeapon = repository.getWeapons().get(first);
        Weapon secondWeapon = repository.getWeapons().get(second);

        if (firstWeapon.compareTo(secondWeapon) >= 0) {
            System.out.println(String.format("%s (Item Level: %.1f)", firstWeapon, firstWeapon.calculateLevel()));
        } else {
            System.out.println(String.format("%s (Item Level: %.1f)", secondWeapon, secondWeapon.calculateLevel()));
        }
    }

    private static void removeGem(String name, Integer index, WeaponRepository repository) {
        repository.getWeapons().get(name).removeGem(index);
    }

    private static void printWeapon(String name, WeaponRepository repository) {
        Weapon weaponType = repository.getWeapons().get(name);

        if (weaponType == null) {
            return;
        }

        System.out.println(weaponType);
    }

    private static void addGem(String weaponName, int socket, String gemType, WeaponRepository repository) {
        repository.getWeapons().get(weaponName).addGem(GemFactory.createGem(gemType), socket);
    }

    private static void createWeapon(String arg, String arg1, WeaponRepository repository) {
        repository.getWeapons().put(arg1, WeaponFactory.createWeapon(arg, arg1));
    }
}
