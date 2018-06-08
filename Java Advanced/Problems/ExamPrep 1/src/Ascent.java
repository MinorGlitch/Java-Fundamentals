import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ascent {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Pattern pattern = Pattern.compile("([,_])([A-Za-z]+)(\\d)");

        Map<String, String> decodedMessages = new LinkedHashMap<>();

        String line = reader.readLine();

        while (!"Ascend".equals(line)) {
            for (Map.Entry<String, String> decodedMessagesEntry : decodedMessages.entrySet()) {
                line = line.replaceAll(decodedMessagesEntry.getKey(), decodedMessagesEntry.getValue());
            }

            Matcher matcher = pattern.matcher(line);

            while (matcher.find()) {
                String decodeType = matcher.group(1);
                String message = matcher.group(2);
                int decodeKey = Integer.valueOf(matcher.group(3));

                String decodedMessage = decode(decodeType, message, decodeKey);

                line = line.replaceAll(matcher.group(0), decodedMessage);

                decodedMessages.putIfAbsent(matcher.group(0), decodedMessage);
            }

            System.out.println(line);

            line = reader.readLine();
        }
    }

    private static String decode(String decodeType, String message, int decodeKey) {
        if (decodeType.equals("_")) {
            decodeKey *= -1;
        }

        char[] chars = message.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            chars[i] += decodeKey;
        }

        return new String(chars);
    }
}
