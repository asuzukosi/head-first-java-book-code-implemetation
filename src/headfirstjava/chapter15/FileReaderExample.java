package headfirstjava.chapter15;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class FileReaderExample {
    public static void main(String[] args) {
        File file = new File("sample.txt");

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = "";
            while((line=reader.readLine()) != null){
                System.out.println(line);
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
