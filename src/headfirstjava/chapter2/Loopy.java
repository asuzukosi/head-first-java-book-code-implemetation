package headfirstjava.chapter2;

public class Loopy {
    public static void main(String[] args) {
        System.out.println("Starting the loop ...");
        int x = 10;

        while (x > 0) {
            System.out.println("Inside the loop");
            System.out.println("The value of x is : " + x--);
        }

        System.out.println("After the loop...");
    }
}
