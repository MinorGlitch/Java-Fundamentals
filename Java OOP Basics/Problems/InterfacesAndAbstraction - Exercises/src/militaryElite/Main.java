package militaryElite;

import militaryElite.commando.Commando;
import militaryElite.engineer.Engineer;
import militaryElite.leutenantGeneral.LieutenantGeneral;
import militaryElite.privateSoldier.IPrivate;
import militaryElite.privateSoldier.Private;
import militaryElite.soldier.BaseSoldier;
import militaryElite.soldier.ISoldier;
import militaryElite.spy.Spy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    private static Map<String, IPrivate> privates = new LinkedHashMap<>();
    private static Map<String, ISoldier> soldiers = new LinkedHashMap<>();


    //TODO: REFACTOR toString Methods!!!
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String line = reader.readLine();

        while (!"End".equals(line)) {
            createSoldier(line.split(" "));
            line = reader.readLine();
        }

        soldiers.values().forEach(s -> System.out.println(s.toString()));
    }

    private static void createSoldier(String[] soldierArgs) {
        String type = soldierArgs[0];

        BaseSoldier privateSoldier = null;

        switch (type) {
            case "Private":
                Private tempSoldier = new Private(soldierArgs[1], soldierArgs[2],
                        soldierArgs[3], Double.valueOf(soldierArgs[4]));
                soldiers.putIfAbsent(soldierArgs[1], tempSoldier);
                privates.putIfAbsent(soldierArgs[1], tempSoldier);
                break;
            case "LeutenantGeneral":
                privateSoldier = new LieutenantGeneral(soldierArgs[1], soldierArgs[2],
                        soldierArgs[3], Double.valueOf(soldierArgs[4]), getPrivates(soldierArgs));
                break;
            case "Engineer":
                try {
                    privateSoldier = new Engineer(soldierArgs[1], soldierArgs[2],
                            soldierArgs[3], Double.valueOf(soldierArgs[4]), soldierArgs[5], getRepairArgs(soldierArgs));
                } catch (IllegalArgumentException ignored) {
                }
                break;
            case "Commando":
                try {
                    privateSoldier = new Commando(soldierArgs[1], soldierArgs[2],
                            soldierArgs[3], Double.valueOf(soldierArgs[4]), soldierArgs[5], getMissionArgs(soldierArgs));
                } catch (IllegalArgumentException ignored) { }
                break;
            case "Spy":
                privateSoldier = new Spy(soldierArgs[1], soldierArgs[2], soldierArgs[3], soldierArgs[4]);
                break;
            default:
                break;
        }

        if (privateSoldier != null) {
            soldiers.putIfAbsent(soldierArgs[1], privateSoldier);
        }
    }

    private static List<String> getMissionArgs(String[] soldierArgs) {
        return Arrays.stream(soldierArgs).skip(6).collect(Collectors.toList());
    }

    private static List<String> getRepairArgs(String[] soldierArgs) {
        return Arrays.stream(soldierArgs).skip(6).collect(Collectors.toList());
    }

    private static Set<IPrivate> getPrivates(String[] soldierArgs) {
        List<String> ids = Stream.of(soldierArgs).skip(5).collect(Collectors.toList());

        return privates.values().stream().filter(p -> ids.contains(p.getId()))
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }
}
