package work_with_files;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterEx {
    public static void main(String[] args) throws IOException {
        String rubai = "Много лет размышлял я над жизнью земной.\n" +
                "Непонятного нет для меня под луной.\n" +
                "Мне известно, что мне ничего не известно! —\n" +
                "Вот последняя правда, открытая мной.";

        String s = "Privet";


        try(FileWriter fileWriter = new FileWriter("test.txt",true);)
        {
//            for (int i = 0; i < rubai.length(); i++) {
//                fileWriter.write(rubai.charAt(i));
//            }
            fileWriter.write(s);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Done");



    }
}
