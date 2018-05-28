import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SerializeArrayList {
    public static void main(String[] args) {

        List<Double> list = new ArrayList<>();

        try (FileOutputStream fos = new FileOutputStream("./resources/list.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            oos.writeObject(list);

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
}
