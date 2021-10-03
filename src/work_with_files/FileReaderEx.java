package work_with_files;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderEx {
    public static void main(String[] args) throws IOException {

        try(FileReader fileReader = new FileReader("test.txt")) {
            int character;
            while ((character = fileReader.read()) != -1) {
                System.out.print((char)character);
            }
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Done");
    }
}
