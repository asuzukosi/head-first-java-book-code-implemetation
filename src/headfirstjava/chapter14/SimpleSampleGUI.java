package headfirstjava.chapter14;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class SimpleSampleGUI implements ActionListener {
    JTextArea text;
    public static void main (String[] args) {
        SimpleSampleGUI gui = new SimpleSampleGUI();
        gui.go();
    }

    public void go() {
        // create frmae and panel
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // create button
        JButton button = new JButton("Just Click It");
        button.addActionListener(this);

        // initiate text area
        text = new JTextArea(10,20);
        text.setLineWrap(true);

        // create scroller and add text area to scoller
        JScrollPane scroller = new JScrollPane(text);
        scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        
        // add scroller to panel
        panel.add(scroller);

        // add panel and button to the frame
        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.getContentPane().add(BorderLayout.SOUTH, button);

        frame.setSize(300, 300);
        frame.setVisible(true);

        }


    public void actionPerformed(ActionEvent ev) {
        text.append("button clicked \n");
        }
}
