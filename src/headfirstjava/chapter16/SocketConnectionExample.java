package headfirstjava.chapter16;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketConnectionExample {

    public static void main(String[] args) {
        BufferedReader reader = null;
        PrintWriter writter = null;

        try{
            Socket chatSocket = new Socket("127.0.0.1", 5000);
            
            // set up network reader
            InputStreamReader istream = new InputStreamReader(chatSocket.getInputStream());
            reader = new BufferedReader(istream);

            String message = reader.readLine();
            System.out.println(message);

            // set up network writter
            OutputStreamWriter ostream = new OutputStreamWriter(chatSocket.getOutputStream());
            writter = new PrintWriter(ostream);
            writter.println("Hello World!");

            chatSocket.close();


        } catch(IOException exception){
            exception.printStackTrace();
        }

    }
}
