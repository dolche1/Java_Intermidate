package work_with_files;

import java.io.*;

public class DataStringsEx {
    public static void main(String[] args) {
        try (DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream("my_test.bin"));
             DataInputStream dataInputStream = new DataInputStream(new FileInputStream("my_test.bin"))) {
            dataOutputStream.writeBoolean(true);
            dataOutputStream.writeByte(1234);
            dataOutputStream.writeChar(88);
            dataOutputStream.writeShort(120);
            dataOutputStream.writeInt(20);
            dataOutputStream.writeLong(1_000_000);
            dataOutputStream.writeFloat(1_000_000.2f);
            dataOutputStream.writeDouble(1_000.0099);

            System.out.println(dataInputStream.readBoolean());
            System.out.println(dataInputStream.readByte());
            System.out.println(dataInputStream.readChar());
            System.out.println(dataInputStream.readShort());
            System.out.println(dataInputStream.readInt());
            System.out.println(dataInputStream.readLong());
            System.out.println(dataInputStream.readFloat());
            System.out.println(dataInputStream.readLong());


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
