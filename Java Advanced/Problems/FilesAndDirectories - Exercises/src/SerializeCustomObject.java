import java.io.*;

public class SerializeCustomObject {
    public static void main(String[] args) {
        try (FileOutputStream fos = new FileOutputStream("./resources/course.ser");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            Course course = new Course("Alex", 22);

            oos.writeObject(course);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
