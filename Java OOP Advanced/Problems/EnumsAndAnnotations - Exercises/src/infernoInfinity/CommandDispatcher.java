package infernoInfinity;

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
        }
    }

    private static void removeGem(String name, Integer index, WeaponRepository repository) {
        repository.getWeapons().get(name).removeGem(index);
    }

    private static void printWeapon(String name, WeaponRepository repository) {
        Weapon weapon = repository.getWeapons().get(name);

        if (weapon == null) {
            return;
        }

        System.out.println(name + ": " + weapon);
    }

    private static void addGem(String weaponName, int socket, String gemType, WeaponRepository repository) {
        repository.getWeapons().get(weaponName).addGem(GemFactory.createGem(gemType), socket);
    }

    private static void createWeapon(String arg, String arg1, WeaponRepository repository) {
        repository.getWeapons().put(arg1, WeaponFactory.createWeapon(arg));
    }
}
