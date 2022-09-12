package headfirstjava.chapter5;

public class DogTestDrive {
    public static void main(String[] args) {
        Dog one = new Dog("Sparky", 50);
        one.bark(1);

        Dog two = new Dog("Beethoven", 11);
        two.bark(0);

        Dog three = new Dog("Buddy", 64);
        three.bark(3);
        
        // get the dogs name using a getter
        System.out.println("The dog's name is " + one.getName());
        System.out.println("The dog's size is " + two.getSize());
    }

}
