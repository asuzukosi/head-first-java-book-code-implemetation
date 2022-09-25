package headfirstjava.chapter15;
import java.io.Serializable;

public class GameCharacter implements Serializable {
    String name;
    int power;
    Weapon[] weapons;

    GameCharacter(String name, int power, Weapon[] weapons){
        this.name = name;
        this.power = power;
        this.weapons = weapons;
    }
}
