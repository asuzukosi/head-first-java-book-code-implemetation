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
        JButton east = new JButton("East");
        JButton west = new JButton("West");
        JButton north = new JButton("North");
        JButton south = new JButton("South");
        JButton center = new JButton("Center");



        myFrame.getContentPane().add(BorderLayout.EAST, east);
        myFrame.getContentPane().add(BorderLayout.WEST, west);
        myFrame.getContentPane().add(BorderLayout.NORTH, north);
        myFrame.getContentPane().add(BorderLayout.SOUTH, south);
        myFrame.getContentPane().add(BorderLayout.CENTER, center);

        myFrame.setSize(500,500);
        myFrame.setVisible(true);
    }
}