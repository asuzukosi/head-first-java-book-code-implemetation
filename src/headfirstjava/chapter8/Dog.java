package headfirstjava.chapter8;

public class Dog extends Cannine implements Pet{
    @Override
    public void makeNoise() {
        System.out.println("Bark");
    }

    @Override
    public void beFriendly() {
        System.out.println("Hey I'm a dog being friendly");
    }

    @Override
    public void play() {
        System.out.println("Lets have some fun");
    }
}