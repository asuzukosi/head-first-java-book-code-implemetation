package headfirstjava.chapter14;
import java.net.*;
import java.io.*;
import java.util.*;

public class CyberBeatBoxServer {
    ArrayList<ObjectOutputStream> clientObjectStreams;

    public static void main(String[] args) {
        
    }

    public void go() {
        try {
            ServerSocket serverSocket = new ServerSocket(500);
            while (true) {
                Socket sock = serverSocket.accept();
                System.out.println("got a connection");
                ObjectOutputStream ostream = new ObjectOutputStream(sock.getOutputStream());
                clientObjectStreams.add(ostream);
                Thread t = new Thread(new ClientHandler(sock));
                t.start();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void tellEveryone(Object one, Object two) {
        Iterator it = clientObjectStreams.iterator();
        while(it.hasNext()) {
        try {
            ObjectOutputStream out = (ObjectOutputStream) it.next();
            out.writeObject(one);
            out.writeObject(two);
        }catch(Exception ex) {ex.printStackTrace();}
}
    }
    /**
     * ClientHandler
       implements Runnable     */
    public class ClientHandler implements Runnable{
        ObjectInputStream istream;

        ClientHandler(Socket sock){
            try {
                istream = new ObjectInputStream(sock.getInputStream());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            Object o1;
            Object o2;
            try {
                while((o1 = istream.readObject())!= null){
                    o2 = istream.readObject();
                    tellEveryone(o1, o2);
    
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    
        
    }
}
