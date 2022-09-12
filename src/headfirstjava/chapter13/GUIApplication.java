package headfirstjava.chapter13;

import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.Container;

public class GUIApplication {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        JButton welcomeButton = new JButton("Click Me");
        welcomeButton.setSize(10, 10);
        welcomeButton.addActionListener(new ButtonListener());

        Container container = frame.getContentPane();
        container.add(BorderLayout.CENTER, welcomeButton);
        container.add(BorderLayout.WEST, new MyDrawPanel());

        frame.setSize(300, 300);
        frame.setVisible(true);

        // Set this so that the application will close once excited
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
    }
}
