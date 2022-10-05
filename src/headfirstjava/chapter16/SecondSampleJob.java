package headfirstjava.chapter16;

public class SecondSampleJob implements Runnable{

    @Override
    public void run() {
        System.out.println("Starting Job 2..");

        for(long i =6; i < 780l; i++){
                System.out.println(i + "from job 2");
        }
        System.out.println("Ending Job 2");
    }
    
}
