package headfirstjava.chapter13;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.Color;

public class SimpleGUI3C {
    JFrame frame;
    String leftText = "Initial text";
    int x = 0;
    int y = 70;
    JLabel label = new JLabel(leftText);
    String[] leftTextOptions = { "random", "england", "oxford", "sympathy" };
    MyDrawPanel drawPanel = new MyDrawPanel();

    public class LabelButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent arg0) {
            leftText = leftTextOptions[(int) (Math.random() * leftTextOptions.length)];
            label.setText(leftText);
        }

    }

    public class ColorButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent arg0) {
            rollBall();
        }
    }

    class MyDrawPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            g.fillRect(0, 0, this.getWidth(), this.getHeight());

            int red = (int) (Math.random() * 255);
            int green = (int) (Math.random() * 255);
            int blue = (int) (Math.random() * 255);

            Color randomColor = new Color(red, green, blue);
            g.setColor(randomColor);
            g.fillOval(x, y, 100, 100);

        }
    }

    public static void main(String[] args) {
        SimpleGUI3C gui = new SimpleGUI3C();
        gui.go();
    }

    public void go() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton button = new JButton("Change circle color");
        button.addActionListener(new ColorButtonListener());

        JButton button2 = new JButton("Change left text");
        button2.addActionListener(new LabelButtonListener());

        frame.getContentPane().add(BorderLayout.SOUTH, button);
        frame.getContentPane().add(BorderLayout.CENTER, drawPanel);
        frame.getContentPane().add(BorderLayout.WEST, label);
        frame.getContentPane().add(BorderLayout.EAST, button2);

        frame.setSize(500, 500);
        frame.setVisible(true);
    }

    public void rollBall(){
        x = 0;
        drawPanel.repaint();
        countTo1000();
        for (int i = 0; i < 160; i++) {
            x++;
            countTo1000();
            drawPanel.repaint();
        }
    }


    public void countTo1000(){
        for(int i=0;  i < 10000; i++){

        }
    }
}
