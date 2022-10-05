package headfirstjava.chapter16;

public class FirstSampleJob implements Runnable {
    @Override
    public void run() {
        System.out.println("Starting Job 1..");

        for(int i =1000; i > 70; i--){
                System.out.println(i + "from job 1");
        }
        System.out.println("Ending Job 1");
    }
}
