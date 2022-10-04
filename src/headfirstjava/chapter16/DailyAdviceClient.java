package headfirstjava.chapter16;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class DailyAdviceClient {
    public static void main(String[] args) {
        DailyAdviceClient client = new DailyAdviceClient();
        client.go();
    }

    public void go() {
        try {
            Socket socket = new Socket("127.0.0.1", 5000);
            InputStreamReader istream = new InputStreamReader(socket.getInputStream());
            BufferedReader reader = new BufferedReader(istream);
            reader.readLine();

            socket.close();

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

    }
}

