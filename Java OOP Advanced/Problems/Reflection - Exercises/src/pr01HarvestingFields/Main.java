package pr01HarvestingFields;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String line = reader.readLine();

        List<Field> fields = Arrays.asList(RichSoilLand.class.getDeclaredFields());

        while (!"HARVEST".equals(line)) {
            switch (line) {
                case "private":
                    fields.stream().filter(f -> Modifier.isPrivate(f.getModifiers())).forEach(Main::FormatResult);
                    break;
                case "protected":
                    fields.stream().filter(f -> Modifier.isProtected(f.getModifiers())).forEach(Main::FormatResult);
                    break;
                case "public":
                    fields.stream().filter(f -> Modifier.isPublic(f.getModifiers())).forEach(Main::FormatResult);
                    break;
                default:
                    fields.forEach(Main::FormatResult);
                    break;
            }

            line = reader.readLine();
        }
    }

    private static void FormatResult(Field field) {
        System.out.println(String.format("%s %s %s",
                Modifier.toString(field.getModifiers()),
                field.getType().getSimpleName(),
                field.getName()));
    }
}
