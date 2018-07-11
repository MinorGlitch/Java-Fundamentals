package genericScale;

public class Main {
    public static void main(String[] args) {
        Scale<String> stringScale = new Scale<>("aa", "bb");

        System.out.println(stringScale.getHeavier());
    }
}
