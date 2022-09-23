package headfirstjava.chapter13;

import java.awt.Color;
import java.awt.Graphics;

import javax.sound.midi.ControllerEventListener;
import javax.sound.midi.ShortMessage;
import javax.swing.JPanel;
import java.awt.Graphics2D;

public class MusicVideoMusicListener extends JPanel implements ControllerEventListener {
    
    boolean msg = false;
    
    @Override
    public void controlChange(ShortMessage event) {
        System.out.println("I got the event");    
        msg = true;
        repaint();    
    }
    
    @Override
    protected void paintComponent(Graphics graphics) {
        if(msg){
            Graphics2D g = (Graphics2D) graphics; 
            int r = (int) (Math.random() * 250);
            int gr = (int) (Math.random() * 250);
            int b = (int) (Math.random() * 250);

            g.setColor(new Color(r,gr,b));

            int ht = (int) ((Math.random() * 120) + 10);
            int width = (int) ((Math.random() * 120) + 10);
            int x = (int) ((Math.random() * 40) + 10);
            int y = (int) ((Math.random() * 40) + 10);
            g.fillRect(x,y,ht, width);
            msg = false;
        }
    }
}
