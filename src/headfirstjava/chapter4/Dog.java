package headfirstjava.chapter4;

public class Dog {
    public String name;

    public Dog(String name) {
        this.name = name;
    }

    public void bark() {
        System.out.println("Woof");
    }

    public void chaseCat() {
        System.out.println("I'm chasing a cat");
    }

    public void eat() {
        System.out.println("num num num");
    }
}
