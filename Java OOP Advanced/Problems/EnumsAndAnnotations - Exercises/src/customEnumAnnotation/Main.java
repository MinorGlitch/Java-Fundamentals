package customEnumAnnotation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.annotation.Annotation;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String type = reader.readLine();

        if (type.equals("Rank")) {
            System.out.printf("Type = %s, Description = %s%n",
                    CardRank.class.getAnnotation(MyAnnotation.class).type(),
                    CardRank.class.getAnnotation(MyAnnotation.class).description());
        } else {
            System.out.printf("Type = %s, Description = %s",
                    CardSuit.class.getAnnotation(MyAnnotation.class).type(),
                    CardSuit.class.getAnnotation(MyAnnotation.class).description());
        }
    }
}
