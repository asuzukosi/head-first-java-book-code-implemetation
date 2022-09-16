package headfirstjava.chapter14;
import javax.swing.JFrame;

import java.awt.BorderLayout;
import javax.swing.JButton;

class BoxLayoutSample {
    public static void main(String[] args) {
        BoxLayoutSample layout = new BoxLayoutSample();
        layout.go();
    }

    public void go() {
        JFrame myFrame = new JFrame();
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton myButton = new JButton("click me");

        myFrame.getContentPane().add(BorderLayout.EAST, myButton);
        myFrame.setSize(200,200);
        myFrame.setVisible(true);
    }
}