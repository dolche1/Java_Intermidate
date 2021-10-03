package work_with_files;

import java.io.*;

public class CopyEx {
    public static void main(String[] args) {


        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("/Users/dolche/Downloads/WQTVY.png"));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("WQTVY.png"))) {
//            int character;
//            while ((character = bufferedReader.read()) != -1) {
//                bufferedWriter.write((char) character);
//            }
            int line;
            while ((line = bufferedReader.read()) != -1) {
                bufferedWriter.write(line);
                bufferedWriter.write('\n');
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Done");
    }
}
