import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class CreateZipArchive {
    public static void main(String[] args) {
        try {
            FileOutputStream fos = new FileOutputStream("./resources/output.zip");
            ZipOutputStream zos = new ZipOutputStream(fos);

            String first = "./resources/input.txt";
            String second = "./resources/inputOne.txt";
            String third = "./resources/inputTwo.txt";

            List<String> files = new ArrayList<>();

            Collections.addAll(files, first, second, third);

            for (String file : files) {
                addToZip(file, zos);
            }

            zos.close();
            fos.close();

            System.out.println();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private static void addToZip(String fileName, ZipOutputStream zos) throws IOException {
        FileInputStream fis = new FileInputStream(fileName);

        ZipEntry zipEntry = new ZipEntry(fileName);
        zos.putNextEntry(zipEntry);

        int length = fis.read();
        while (length >= 0) {
            zos.write(length);
            length = fis.read();
        }

        zos.closeEntry();
        fis.close();
    }
}
