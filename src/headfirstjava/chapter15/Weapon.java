package headfirstjava.chapter15;

import java.io.Serializable;

public class Weapon implements Serializable {
    String name;

    Weapon(String name){
        this.name = name;
    }
}
