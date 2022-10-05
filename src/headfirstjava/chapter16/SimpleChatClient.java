package headfirstjava.chapter16;
import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.event.*;
import java.io.PrintWriter;
import java.net.Socket;


public class SimpleChatClient {
    JTextField outgoing;
    PrintWriter writer;
    Socket sock;


    public static void main(String[] args) {
        SimpleChatClient client = new SimpleChatClient();
        client.go();
    }
    public void go() {
        JFrame frame = new JFrame("Ludicrously Simple Chat Client");
        JPanel mainPanel = new JPanel();
        outgoing = new JTextField(20);
        frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
        JButton sendButton = new JButton("Send");

        sendButton.addActionListener(new SendButtonListender());
        mainPanel.add(outgoing);
        mainPanel.add(sendButton);

        setUpNetworing();
        frame.setSize(400, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);


    }

    public void setUpNetworing() {
        try {
            sock = new Socket("127.0.0.1", 5000);
            writer = new PrintWriter(sock.getOutputStream());
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
}
