package headfirstjava.chapter16;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class DailyAdviceServer {

    String[] adviceList = {"Take smaller bites", "Go for the tight jeans. No they do NOT make you look fat.", 
                            "One word: inappropriate", 
                            "Just for today, be honest. Tell your boss what you *really* think", 
                            "You might want to rethink that haircut."};

    public static void main(String[] args) {
        DailyAdviceServer server = new DailyAdviceServer();
        server.go();
    }

    private String getAdvice() {
        int random = (int) (Math.random() * adviceList.length);
        return adviceList[random];
    }

    public void go() {
        try {
            ServerSocket server = new ServerSocket(5000);

            while (true) {
                Socket socket = server.accept();
                PrintWriter writter = new PrintWriter(socket.getOutputStream());
                String advice = getAdvice();
                writter.println(advice);
                writter.close();
                System.out.println(advice);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
