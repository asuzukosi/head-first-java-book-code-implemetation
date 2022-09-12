package headfirstjava.chapter12;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequencer;


public class MusicTest {
    public static void play() {
        try{
            Sequencer sequencer = MidiSystem.getSequencer();
            System.out.println("We've got a sequencer");
            System.out.println(sequencer);
        }catch(MidiUnavailableException ex){
            System.out.println("Bummer");
        }

    }

    public static void main(String[] args) {
        play();
        try{
            exceptionThrowingMethod();
        }catch(BadException ex){
            System.out.println(ex.getMessage());
        }
        testingFinally();

        try{
            doLaundry();
        } catch(BraException ex) {
            System.out.println("Bra exception");
        } catch(PantException ex){
            System.out.println("Pant exception");
        }
    }

    public static void exceptionThrowingMethod() throws BadException {
        throw new BadException();
    }

    public static void testingFinally() {
        try{
            exceptionThrowingMethod();
            System.out.println("Oh wow interesting");
        } catch(BadException ex){
            System.out.println(ex);
            return;
        }finally{
            System.out.println("Haaa I'm not out yet");
        }
    }

    public static void doLaundry() throws PantException, BraException {
        System.out.println("In the do laundry");
    }
}
