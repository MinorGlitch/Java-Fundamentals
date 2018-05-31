import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ParseURL {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] urlParts = reader.readLine().split("://");

        if (urlParts.length != 2) {
            System.out.println("Invalid URL");
            return;
        }

        String protocol = urlParts[0];

        String server = urlParts[1].substring(0, urlParts[1].indexOf('/'));

        String resources = urlParts[1].substring(urlParts[1].indexOf('/') + 1);

        System.out.println("Protocol = " + protocol);
        System.out.println("Server = " + server);
        System.out.println("Resources = " + resources);
    }
}
