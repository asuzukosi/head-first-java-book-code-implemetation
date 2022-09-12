package headfirstjava.chapter10;

public class App {
    public static void main(String[] args) {
        Duck d1 = new Duck(4);
        Duck d2 = new Duck();

        System.out.println("Welcome to chapter 10: Object life cycle");
        System.out.println("The size of duck 1 is : " + d1.getSize());
        System.out.println("The size of duck 2 is : " + d2.getSize());

        Hippo hippo = new Hippo();
        System.out.println(hippo);

    }
}
