package headfirstjava.chapter15;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class ObjectReadingExample {
    public static void main(String[] args) {
        try{
            FileInputStream fis = new FileInputStream("gameCharacters.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);

            Object sample = ois.readObject();
            GameCharacter characters = (GameCharacter) sample;
            System.out.println("The first character is " + characters);
            ois.close();

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
