package headfirstjava.chapter4;

public class DogTestDrive {
    public static void main(String[] args) {
        Dog[] pets  = new Dog[3];
        pets[0] = new Dog("Fido");
        pets[1] = new Dog("Spot");
        
        pets[2] = new Dog("Scooby");
        for (int i = 0; i < pets.length; i++) {
            System.out.println("My dog's name is " + pets[i].name);
            pets[i].bark();
            pets[i].chaseCat();
            pets[i].eat();
        }

        Dog fido = pets[0];
        fido.bark();
    }
}
