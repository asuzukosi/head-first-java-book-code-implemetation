package headfirstjava.chapter19;
import java.rmi.*;


public class MyClient {
    

    public static void main(String[] args) {
        MyClient client = new MyClient();
        client.go();
    }

    public void go() {
        try {
            MyRemote service = (MyRemote) Naming.lookup("rmi://127.0.0.1/RemoteHello");
            String s = service.sayHello();
            System.out.println(s);
        } catch(Exception ex) {
            ex.printStackTrace();
        }   
    }   
}