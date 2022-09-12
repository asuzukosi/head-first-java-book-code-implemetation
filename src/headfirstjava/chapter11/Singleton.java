package headfirstjava.chapter11;

public class Singleton {
    static Singleton instance = new Singleton();

    private Singleton(){
    }

    public void message(){
        System.out.println("I'm alive!");
    }
}
