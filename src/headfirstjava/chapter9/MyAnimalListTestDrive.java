package headfirstjava.chapter9;

import headfirstjava.chapter8.Cat;
import headfirstjava.chapter8.Dog;

public class MyAnimalListTestDrive {
    public static void main(String[] args) {
        MyAnimalList animalList = new MyAnimalList();
        Cat c = new Cat();
        Dog d = new Dog();
        
        animalList.add(c);
        animalList.add(d);
        System.out.println("Done adding stuff");
    }
}
