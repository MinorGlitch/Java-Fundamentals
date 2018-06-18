package familyTree;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Patterns {
    private static Pattern nameAndName = Pattern.compile("^([\\w\\s]+) ([\\w\\s]+) - ([\\w\\s]+) ([\\w\\s]+)$");
    private static Pattern nameAndDate = Pattern.compile("^([\\w\\s]+) ([\\w\\s]+) - (\\d+/\\d+/\\d+)$");
    private static Pattern dateAndName = Pattern.compile("^(\\d+/\\d+/\\d+) - ([\\w\\s]+) ([\\w\\s]+)$");
    private static Pattern dateAndDate = Pattern.compile("^(\\d+/\\d+/\\d+) - (\\d+/\\d+/\\d+)$");
    private static Pattern nameAndDateNoHyphens = Pattern.compile("^([\\w\\s]+) ([\\w\\s]+) (\\d+/\\d+/\\d+)$");
    private static final String NAME_PATTERN = "([\\w\\s]+) ([\\w\\s]+)";
    private static final String DATE_PATTERN = "(\\d+/\\d+/\\d+)";

    public static boolean isDate(String argument) {
        return argument.matches(DATE_PATTERN);
    }

    public static Matcher getNameAndName(String line) {
        return nameAndName.matcher(line);
    }

    public static Matcher getNameAndDate(String line) {
        return nameAndDate.matcher(line);
    }

    public static Matcher getDateAndName(String line) {
        return dateAndName.matcher(line);
    }

    public static Matcher getDateAndDate(String line) {
        return dateAndDate.matcher(line);
    }

    public static Matcher getNameAndDateNoHyphens(String line) {
        return nameAndDateNoHyphens.matcher(line);
    }

    public static boolean matches(Matcher matcher) {
        return matcher.find();
    }
}
