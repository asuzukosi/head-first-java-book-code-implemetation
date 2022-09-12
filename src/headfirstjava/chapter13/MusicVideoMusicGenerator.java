package headfirstjava.chapter13;

import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;
import javax.swing.JFrame;

public class MusicVideoMusicGenerator {

    /*
     * Settin up my Jframe and Music vidio listener
     */
    static JFrame f = new JFrame("My First Music Video");
    static MusicVideoMusicListener ml;

    /**
     * This is the static method responsible for making the 
     * sound events by passing in the required parameters
     */
    public static MidiEvent makeEvent(int comd, int chan, int one, int two, int tick) {
        MidiEvent event = null;
        try {
            ShortMessage message = new ShortMessage();
            message.setMessage(comd, chan, one, two);
            event = new  MidiEvent(message, tick);
        } catch (Exception e) {}

        return event;
    }

    public static void setUpGui() {
        ml = new MusicVideoMusicListener();
        f.setContentPane(ml);
        f.setBounds(30,30, 300,300);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public static void main(String[] args) {
        setUpGui();
        try{
            Sequencer sequencer = MidiSystem.getSequencer();
            sequencer.open();
            int[] eventsIWant = {127};
            sequencer.addControllerEventListener(ml, eventsIWant);

            Sequence sequence = new Sequence(Sequence.PPQ, 4);
            Track track = sequence.createTrack();


            int r = 0;
            for (int index = 5; index < 61; index+=4) {
                r = (int) ((Math.random() * 50) + 1);
                track.add(makeEvent(144,1,r,100,index));
                track.add(makeEvent(176,1,127,0,index));
                track.add(makeEvent(128,1,r,100,index+2));
            }

            sequencer.setSequence(sequence);
            sequencer.setTempoInBPM(220);
            sequencer.start();
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
