package headfirstjava.finalproject;
import javax.swing.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.awt.*;
import java.text.*;

public class DayOfTheWeekService implements Service {

    JLabel outputLabel;
    JComboBox<String> month;
    JTextField day;
    JTextField year;

    @Override
    public JPanel getGuiPanel() {
        JPanel panel = new JPanel();

        JButton button = new JButton("Do it!");
        button.addActionListener(new DoItListener());

        outputLabel = new JLabel("date appears here");

        DateFormatSymbols dateStuff = new DateFormatSymbols();
        month = new JComboBox<String>(dateStuff.getMonths());

        day = new JTextField(8);
        year = new JTextField(8);

        JPanel inputPanel = new JPanel(new GridLayout(3,2));

        inputPanel.add(new JLabel("Month"));
        inputPanel.add(month);
        inputPanel.add(new JLabel("Day"));
        inputPanel.add(day);
        inputPanel.add(new JLabel("Year"));
        inputPanel.add(year);

        panel.add(inputPanel);
        panel.add(button);
        panel.add(outputLabel);
        
        return panel;
    }


    /**
     * InnerDayOfTheWeekService
     */
    public class DoItListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Integer parseMonth = (Integer) month.getSelectedIndex();
            Integer parseDay = Integer.parseInt(day.getText());
            Integer parseYear = Integer.parseInt(year.getText());

            Calendar c = Calendar.getInstance();
            c.set(parseYear, parseMonth, parseDay);
            Date date = c.getTime();
            String dayOfTheWeek = (new SimpleDateFormat("EEEE")).format(date);
            outputLabel.setText(dayOfTheWeek);
            
        }
    
        
    }
    
}
