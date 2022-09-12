package headfirstjava.chapter8;

public class Vet {
    public void giveShot(Animal a) {
        System.out.println("Vet gives shot to animal");
        a.makeNoise();
    }
}
