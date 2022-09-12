package headfirstjava.chapter13;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class MyDrawPanel extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(20, 50, 100, 100);
    }
}
