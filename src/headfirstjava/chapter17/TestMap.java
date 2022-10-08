package headfirstjava.chapter17;
import java.util.*;

public class TestMap {
    public static void main(String[] args) {
        HashMap<String, Integer> scores = new HashMap<String, Integer>();
        scores.put("Kathy", 12);
        scores.put("David", 142);

        System.out.println(scores);
        System.out.println(scores.get("Kathy"));
        System.out.println(scores.get("Kat"));

        ArrayList<Animal> animals = new ArrayList<Animal>();
        Dog d = new Dog();
        Cat c = new Cat();

        animals.add(d);
        animals.add(c);

        takeAnimals(animals);

        ArrayList<Dog> dogs = new ArrayList<Dog>();
        dogs.add(d);

        takeAnimals(dogs);


    }

    public static void takeAnimals(ArrayList<? extends Animal> animals) {
        for(Animal a:animals){
            a.eat();
        }
    }

    /**
     * InnerTestMap
     */
    public static abstract class Animal {
        public void eat() {
            System.out.println("I am eating");
        }
    }

    /**
     * Dog
     */
    public static class Dog extends Animal{
        
    }

    /**
     * Cat extends Ainimal
     */
    public static class Cat extends Animal {
        
    }

}
