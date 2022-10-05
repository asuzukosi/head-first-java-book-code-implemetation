package headfirstjava.chapter16;

public class MutltiThreadingExample {
    public static void main(String[] args) {
        Thread firstThread = new Thread(new FirstSampleJob());
        Thread secondThread = new Thread(new SecondSampleJob());

        firstThread.start();
        secondThread.start();

        for (int index = 0; index < 1000; index++) {
            System.out.println(index + "from main tread");
        }

        System.out.println("Main execution ended");
    }

}
