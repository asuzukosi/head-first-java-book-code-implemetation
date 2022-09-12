package headfirstjava.chapter8;

public class Cat extends Feline implements Pet{
    @Override
    public void makeNoise() {
        super.makeNoise();
        System.out.println("Make cat noise");
    }

    @Override
    public void beFriendly() {
        System.out.println("Hey I'm a cat being friendly");
    }

    @Override
    public void play() {
        System.out.println("Lets have some fun");
    }
}
