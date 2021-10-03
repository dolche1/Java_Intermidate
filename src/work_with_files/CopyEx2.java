package work_with_files;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyEx2 {
    public static void main(String[] args) {
        try (FileInputStream fileInputStream = new FileInputStream("/Users/dolche/Downloads/WQTVY.png");
             FileOutputStream fileOutputStream = new FileOutputStream("WQTVY.png")) {
            int bt;
            while ((bt = fileInputStream.read()) != -1) {
                fileOutputStream.write(bt);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
