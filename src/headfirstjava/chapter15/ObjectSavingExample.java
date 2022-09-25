package headfirstjava.chapter15;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ObjectSavingExample implements Serializable {
    public static void main(String[] args) {
        Weapon bow = new Weapon("bow");
        Weapon sword = new Weapon("sword");
        Weapon dust = new Weapon("dust");

        Weapon[] elfWeapons = {bow, sword, dust};

        GameCharacter elf = new GameCharacter("Elf", 50, elfWeapons);
        
        Weapon bareHands = new Weapon("bare hands");
        Weapon bigAx = new Weapon("big ax");

        Weapon[] trolWeapons = {bareHands, bigAx};

        GameCharacter troll = new GameCharacter("Troll", 200, trolWeapons);

        GameCharacter[] characters = {elf, troll};


        try {
            FileOutputStream fileOutput = new FileOutputStream("gameCharacters.ser");
            ObjectOutputStream objectStream = new ObjectOutputStream(fileOutput);
            objectStream.writeObject(characters);
            objectStream.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
