package headfirstjava.chapter8;

public class App {
    public static void main(String[] args) {
        Animal[] animals = new Animal[2];
        animals[0] = new Cat();
        animals[1] = new Dog();

        Vet vet = new Vet();

        for (Animal a : animals) {
            vet.giveShot(a);
        }
    }
}
