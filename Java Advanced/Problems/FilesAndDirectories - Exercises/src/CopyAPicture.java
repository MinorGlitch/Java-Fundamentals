import java.io.*;

public class CopyAPicture {
    public static void main(String[] args) {

        try (FileInputStream fis = new FileInputStream("./resources/pic.png");
             FileOutputStream fos = new FileOutputStream("./resources/output.jpg")) {
            byte[] buffer = fis.readAllBytes();

            fos.write(buffer);

            System.out.println();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
