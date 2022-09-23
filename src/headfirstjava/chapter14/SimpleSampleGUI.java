package headfirstjava.chapter14;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.event.*;

public class SimpleSampleGUI implements ActionListener, ItemListener, ListSelectionListener {
    JTextArea text;
    Boolean canSet = true;
    JCheckBox checkBox = new JCheckBox();
    String [] listEntries = {"alpha", "beta", "gamma", "delta", "epsilon", "zeta", "eta", "theta "};
    JList<String> list = new JList<String>(listEntries);


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
        JPanel otherPanel = new JPanel();
        
        frame.getContentPane().add(BorderLayout.SOUTH, otherPanel);

        
        JScrollPane scroller2 = new JScrollPane(list);
        scroller2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroller2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        list.setVisibleRowCount(4);
        list.addListSelectionListener(this);

        otherPanel.add(button);
        otherPanel.add(checkBox);
        otherPanel.add(scroller2);


        frame.setSize(300, 300);
        frame.setVisible(true);

        }


    public void actionPerformed(ActionEvent ev) {
        if(canSet){
            text.append("button clicked \n");
        }
        }

    @Override
    public void itemStateChanged(ItemEvent e) {
        System.out.println("I am clicked");
        if(checkBox.isSelected()){
            this.canSet = true;
        } else {
            this.canSet = false;
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if( !e.getValueIsAdjusting()) {
            String selection = (String) list.getSelectedValue();
            System.out.println(selection);
        }  
    }
}
