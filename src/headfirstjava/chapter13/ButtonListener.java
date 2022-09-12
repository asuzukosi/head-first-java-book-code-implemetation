package headfirstjava.chapter13;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class ButtonListener implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent arg0) {
        System.out.println("Hello, I am an event that has been triggered");        
    }
    
}
