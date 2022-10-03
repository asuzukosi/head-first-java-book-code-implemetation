package headfirstjava.chapter16;
import java.io.IOException;
import java.net.Socket;

public class SocketConnectionExample {
    public static void main(String[] args) {
        try{
            Socket chatSocket = new Socket("127.0.0.1", 5000);
        } catch(IOException exception){
            exception.printStackTrace();
        }

    }
}
