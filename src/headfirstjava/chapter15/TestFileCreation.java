package headfirstjava.chapter15;
import java.io.File;

public class TestFileCreation {
    public static void main(String[] args) {
        File dir = new File("test");

        dir.mkdir();
        System.out.println(dir.getAbsolutePath());

        if(dir.isDirectory()){
            String[] files = dir.list();
            for(String file: files){
                System.out.println("File is : "+ file);
                File obj = new File(file);
                obj.delete();
                System.out.println("File "+ file + " was deleted");
            }
        }
    }
}
