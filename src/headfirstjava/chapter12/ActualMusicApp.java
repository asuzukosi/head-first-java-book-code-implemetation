package headfirstjava.chapter12;
import javax.sound.midi.Sequencer;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;
import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequence;

public class ActualMusicApp {
    public static void main(String[] args) {
        if(args.length < 2){
            System.out.println("Please enter you intrument and note.");
            return;
        }
        int instrument = Integer.parseInt(args[0]);
        int note = Integer.parseInt(args[1]);

        try {
            
            // Create and open sequencer
            Sequencer player = MidiSystem.getSequencer();
            player.open();
            

            // Create sequence
            Sequence sequence = new Sequence(Sequence.PPQ, 4);
            Track track = sequence.createTrack();
            

            // create shore message and set it as an event on the track
            ShortMessage a = new ShortMessage();
            a.setMessage(144, instrument, note, 100);
            MidiEvent noteOn = new MidiEvent(a, 1);
            track.add(noteOn);

            // Add anothe short message
            ShortMessage b = new ShortMessage();
            b.setMessage(128, instrument, note, 100);
            MidiEvent noteOff = new MidiEvent(b, 20);
            track.add(noteOff);

            // set sequence in sequencer and play sequence
            player.setSequence(sequence);
            player.start();
            System.out.println("Done playing sounds");

        } catch (MidiUnavailableException e) {
            System.out.println("Midi player is unnavailable");
        } catch (InvalidMidiDataException e){
            System.out.println("Invalid midi data exception found");
        }
    }
}
