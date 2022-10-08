package headfirstjava.finalproject;
import javax.swing.*;
import java.awt.event.*;

public class DiceService implements Service{
    JLabel label;
    JComboBox<String> numOfDice;


    @Override
    public JPanel getGuiPanel() {
        JPanel panel = new JPanel();
        JButton button = new JButton("Roll em!");
        button.addActionListener(new RollEmListener());
        String[] choices = {"1", "2", "3", "4", "5"};
        label = new JLabel("Dice values are here");
        numOfDice = new JComboBox<String>(choices);
        panel.add(numOfDice);
        panel.add(button);
        panel.add(label);
        return panel;
    
    }
    
    /**
     * RollEmListener implements ActionListener
     */
    public class RollEmListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent arg0) {
            String diceOutPut = "";
            String selection = (String) numOfDice.getSelectedItem();
            int numOfDiceToRoll = Integer.parseInt(selection);
            
            for(int i = 0; i < numOfDiceToRoll; i ++){
                diceOutPut = diceOutPut + (int)(Math.random() * 7) + " ";
            }
            label.setText(diceOutPut);
        }
    
        
    }
}
