package headfirstjava.chapter15;

import java.io.FileWriter;

public class FileWriterExample {
    public static void main(String[] args) {
        try {
            FileWriter writer = new FileWriter("sample.txt");
            writer.write("Hello there");
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
