package randomArrayList;

public class Main {
    public static void main(String[] args) {
        RandomArrayList randomList = new RandomArrayList() {{
            add("aa");
            add("bb");
            add("cc");
            add("dd");
        }};

        System.out.println(randomList.getRandomElement());
    }
}
