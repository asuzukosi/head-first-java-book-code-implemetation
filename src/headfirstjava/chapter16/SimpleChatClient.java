package headfirstjava.chapter16;
import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class SimpleChatClient {
    JTextField outgoing;
    JTextArea incoming;
    PrintWriter writer;
    BufferedReader reader;
    Socket sock;


    public static void main(String[] args) {
        SimpleChatClient client = new SimpleChatClient();
        client.go();
    }
    public void go() {
        JFrame frame = new JFrame("Ludicrously Simple Chat Client");
        JPanel mainPanel = new JPanel();

        incoming = new JTextArea(15,50);
        incoming.setLineWrap(true);
        incoming.setWrapStyleWord(true);
        incoming.setEditable(false);
        JScrollPane qScroller = new JScrollPane(incoming);
        qScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        qScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        outgoing = new JTextField(20);
        frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
        JButton sendButton = new JButton("Send");

        sendButton.addActionListener(new SendButtonListender());
        mainPanel.add(outgoing);
        mainPanel.add(incoming);
        mainPanel.add(sendButton);

        setUpNetworing();
        frame.setSize(400, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);


    }

    public void setUpNetworing() {
        try {
            sock = new Socket("127.0.0.1", 5000);
            writer = new PrintWriter(sock.getOutputStream());
            reader = new BufferedReader(new InputStreamReader(sock.getInputStream()));
            System.out.println("network established");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    class SendButtonListender implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                writer.println(outgoing.getText());
                writer.flush();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            outgoing.setText("");
            outgoing.requestFocus();
        }

    }

    public class IncomingReader implements Runnable {

        @Override
        public void run() {
            String message;
            try {
                while ((message=reader.readLine()) != null) {
                    System.out.println("read "+ message);
                    incoming.append(message + "\n");
                }
                
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        }
    
        
    }
}
