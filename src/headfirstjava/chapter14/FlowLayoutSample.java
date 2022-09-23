package headfirstjava.chapter14;
import java.awt.*;
import javax.swing.*;

public class FlowLayoutSample {

    public static void main(String[] args) {
        FlowLayoutSample sample = new FlowLayoutSample();
        sample.go();

    }
    
    public void go() {

        JFrame myFrame = new JFrame();
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        JPanel myPanel = new JPanel();
        JPanel innerPanel = new JPanel();
        JPanel horizontalPanel = new JPanel();
        JPanel verticalPanel = new JPanel();

        innerPanel.setLayout(new BoxLayout(innerPanel, BoxLayout.Y_AXIS));
        horizontalPanel.setLayout(new BoxLayout(horizontalPanel, BoxLayout.X_AXIS));
        verticalPanel.setLayout(new BoxLayout(verticalPanel, BoxLayout.Y_AXIS));

        myPanel.setBackground(Color.darkGray);
        innerPanel.setBackground(Color.darkGray);
        verticalPanel.setBackground(Color.darkGray);
        horizontalPanel.setBackground(Color.darkGray);

        JButton myButton = new JButton("click me!");
        JButton anotherButton = new JButton("other button");
        JButton buttonThree = new JButton("huh?");
        JTextField sampleInput = new JTextField();


        myPanel.add(verticalPanel);
        verticalPanel.add(horizontalPanel);

        horizontalPanel.add(myButton);
        horizontalPanel.add(innerPanel);
        innerPanel.add(anotherButton);
        innerPanel.add(buttonThree);
        myPanel.add(new JLabel("hello there"));
        myPanel.add(sampleInput);
        sampleInput.setText("wetin dey oo");

        JTextArea text = new JTextArea(10,20);
        JScrollPane scroller = new JScrollPane(text);
        text.setLineWrap(true);

        scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        myPanel.add(scroller);




        myFrame.getContentPane().add(BorderLayout.EAST, myPanel);
        myFrame.setSize(500, 500);
        myFrame.setVisible(true);

    }
}
