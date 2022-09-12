package headfirstjava.chapter2;

public class MyFirstApp {
    public static void main(String[] args) {
        System.out.println("This is a simple java applicatioin");
        System.out.println("I Rule");
        System.out.println("The world");

        doSomething();
        doSomethingAgain();
        doSomethingUnderThisCondition();
    }

    public static void doSomething() {
        int  x = 3;
        String name = "Kosi";
        x = x * 17;
        double d = Math.random();
        System.out.println(name);
        System.out.println(x);
        System.out.println(d);
    }

    public static void doSomethingAgain() {
        for(int i = 1; i <= 10; i ++){
            System.out.println("The value of i is now " + i);
        }
    }

    public static void doSomethingUnderThisCondition() {
        int x = 10;
        if(x == 10){
            System.out.println("The value of x is ten");
        } else{
            System.out.println("The value of x is not ten");
        }
    }
}
