package headfirstjava.chapter14;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.sound.midi.*;
import java.util.*;
import java.awt.event.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.File;
import java.net.*;


public class CyberBeatBox {

    // Create initial application components
    JPanel mainPanel;
    ArrayList<JCheckBox> checkboxList;
    Sequencer sequencer;
    Sequence sequence;
    Track track;
    JFrame theFrame;
    ObjectInputStream reader;
    ObjectOutputStream writer;
    Vector<String> listVector = new Vector<String>();
    String userName;
    HashMap<String, boolean[]> otherSeqsMap = new HashMap<String, boolean[]>();
    int nextNum;
    JList incomingList;
    JTextField userMessage;
    

    String[] instrumentNames = {"Bass Drum", "Closed Hi-Hat", "Open Hi-Hat","Acoustic Snare", "Crash Cymbal", "Hand Clap",
                                "High Tom", "Hi Bongo", "Maracas", "Whistle", "Low Conga","Cowbell", "Vibraslap", 
                                "Low-mid Tom", "High Agogo","Open Hi Conga"};
    int[] instruments = {35,42,46,38,49,39,50,60,70,72,64,56,58,47,67,63};

    public static void main(String[] args) {
        CyberBeatBox beatBox = new CyberBeatBox();
        beatBox.buildGUI();
    }

    public void buildGUI() {
        // create a frame and give it a name of cyber beat box
        theFrame = new JFrame("Cyber BeatBox");
        theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        userName = "client";

        BorderLayout layout = new BorderLayout();
        JPanel background = new JPanel(layout);

        background.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        checkboxList = new ArrayList<JCheckBox>();
        Box buttonBox = new Box(BoxLayout.Y_AXIS);
        JButton start = new JButton("Start");
        start.addActionListener(new MyStartListener());
        buttonBox.add(start);      
        
        JButton stop = new JButton("Stop");
        stop.addActionListener(new MyStopListener());
        buttonBox.add(stop);

        JButton upTempo = new JButton("Tempo Up");
        upTempo.addActionListener(new MyUpTempoListener());
        buttonBox.add(upTempo);


        JButton downTempo = new JButton("Tempo Down");
        downTempo.addActionListener(new MyDownTempoListener());
        buttonBox.add(downTempo);

        JButton saveIt = new JButton("Save It");
        saveIt.addActionListener(new MySendListener());
        buttonBox.add(saveIt);

        JButton readIt = new JButton("Read It");
        readIt.addActionListener(new MyReadInListener());
        buttonBox.add(readIt);

        JButton sendIt = new JButton("Send It");
        sendIt.addActionListener(new MySendSequenceListener());
        buttonBox.add(sendIt);

        userMessage = new JTextField();
        buttonBox.add(userMessage);
        incomingList = new JList();
        incomingList.addListSelectionListener(new MyListSelectionListener());
        incomingList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane theList = new JScrollPane(incomingList);
        buttonBox.add(theList);
        incomingList.setListData(listVector); // no data to start with

        Box nameBox = new Box(BoxLayout.Y_AXIS);

        for (int i = 0; i < 16; i++) {
            nameBox.add(new Label(instrumentNames[i]));
        }

        background.add(BorderLayout.EAST, buttonBox);
        background.add(BorderLayout.WEST, nameBox);

        theFrame.getContentPane().add(background);
        GridLayout grid = new GridLayout(16,16);
        grid.setVgap(1);
        grid.setHgap(2);
        mainPanel = new JPanel(grid);
        background.add(BorderLayout.CENTER, mainPanel);

        for (int i = 0; i < 256; i++) {
            JCheckBox c = new JCheckBox();
            c.addItemListener(new MyCheckBoxListener());
            c.setSelected(false);
            checkboxList.add(c);
            mainPanel.add(c);
        }

        setUpMidi();
        setUpNetworing();

        theFrame.setBounds(50,50,300,300);
        theFrame.pack();
        theFrame.setVisible(true);
    }

    public void setUpMidi() {
        try {
        sequencer = MidiSystem.getSequencer();
        sequencer.open();
        sequence = new Sequence(Sequence.PPQ,4);
        track = sequence.createTrack();
        sequencer.setTempoInBPM(120);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void buildTrackAndStart() {
        int[] trackList = null;
        sequence.deleteTrack(track);
        track = sequence.createTrack();

        for (int i = 0; i < 16; i++) {
            trackList = new int[16];
            int key = instruments[i];

            for (int j = 0; j < 16; j++ ) {
                JCheckBox jc = (JCheckBox) checkboxList.get(j + (16*i));
                if ( jc.isSelected()) {
                    trackList[j] = key;
                } else {
                    trackList[j] = 0;
                }
            }
            makeTracks(trackList);
            track.add(makeEvent(176,1,127,0,16));
        }

        track.add(makeEvent(192,9,1,0,15));
        try {
            sequencer.setSequence(sequence);
            sequencer.setLoopCount(Sequencer.LOOP_CONTINUOUSLY);
            sequencer.start();
            sequencer.setTempoInBPM(120);
            
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public class MyStartListener implements ActionListener {
        public void actionPerformed(ActionEvent a) {
        buildTrackAndStart();
        }
    }

    public class MyCheckBoxListener implements ItemListener{

        @Override
        public void itemStateChanged(ItemEvent e) {
        sequencer.stop();
        buildTrackAndStart();            
        }

    }

    public class MyStopListener implements ActionListener {
        public void actionPerformed(ActionEvent a) {
        sequencer.stop();
        }
    }

    public class MyUpTempoListener implements ActionListener {
        public void actionPerformed(ActionEvent a) {
        Float tempoFactor = sequencer.getTempoFactor();
        sequencer.setTempoFactor((float)(tempoFactor * 1.03));
        }
    }

    public class MyDownTempoListener implements ActionListener {
        public void actionPerformed(ActionEvent a) {
        float tempoFactor = sequencer.getTempoFactor();
        sequencer.setTempoFactor((float)(tempoFactor * .97));
        }
    }

    public void makeTracks(int[] list) {
        for (int i = 0; i < 16; i++) {
            int key = list[i];
            if (key != 0) {
                track.add(makeEvent(144,9,key, 100, i));
                track.add(makeEvent(128,9,key, 100, i+1));
                }
        }
    }

    public MidiEvent makeEvent(int comd, int chan, int one, int two, int tick) {
        MidiEvent event = null;
        try {
            ShortMessage a = new ShortMessage();
            a.setMessage(comd, chan, one, two);
            event = new MidiEvent(a, tick);
        } catch(Exception e) {
            e.printStackTrace(); 
            }
        return event;
    }

    public class MySendListener implements ActionListener {
        public void actionPerformed(ActionEvent a) {
            boolean[] checkboxState = new boolean[256];
            for (int i = 0; i < 256; i++) {
                JCheckBox check = (JCheckBox) checkboxList.get(i);
                if(check.isSelected()){
                    checkboxState[i] = true;
                }

            }
            JFileChooser ???leOpen = new JFileChooser();
            ???leOpen.showOpenDialog(theFrame);
            File file = ???leOpen.getSelectedFile();

            try {
                FileOutputStream fos = new FileOutputStream(file);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(checkboxState);

                oos.close();
            } catch (Exception e) {
                System.out.println("Could not save chechbox state");
                e.printStackTrace();
            }
        }
    
    }

    public class MyReadInListener implements ActionListener {
        public void actionPerformed(ActionEvent a) {
            JFileChooser ???leOpen = new JFileChooser();
            ???leOpen.showOpenDialog(theFrame);
            File file = ???leOpen.getSelectedFile();

            try { 
                FileInputStream fis = new FileInputStream(file);
                ObjectInputStream ois = new ObjectInputStream(fis);
                Object obj = ois.readObject();
                boolean[] checkboxState = (boolean[])obj;
                changeSequence(checkboxState);
                ois.close();
                
            } catch (Exception e) {
                System.out.println("Unable to read file");
                e.printStackTrace();
            }
        }
    }

    /**
     * MySendSequenceListener implements ActionListener
     */
    public class MySendSequenceListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent arg0) {
            boolean[] checkboxState = new boolean[256];
            for (int i = 0; i < 256; i++) {
                JCheckBox check = (JCheckBox) checkboxList.get(i);
                if(check.isSelected()){
                    checkboxState[i] = true;
                }

            }
            try {
                writer.writeObject(userName);
                writer.writeObject(checkboxState);

            } catch (Exception e) {
                e.printStackTrace();
            }
            
        }
    
        
    }
    public void changeSequence(boolean[] checkboxState) {
        for(int i=0; i < checkboxState.length; i++){
            JCheckBox check = (JCheckBox) checkboxList.get(i);
            check.setSelected(checkboxState[i]);
        }
        sequencer.stop();
        buildTrackAndStart();
    }

    public void setUpNetworing() {
        try {
            Socket sock = new Socket("127.0.0.1", 5000);
            System.out.println("established connection");
            reader = new ObjectInputStream(sock.getInputStream());
            writer = new ObjectOutputStream(sock.getOutputStream());
            Thread t = new Thread(new SreverListener());
            t.start();

        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    /**
     * SreverListener
     */
    public class SreverListener implements Runnable {
        boolean[] checkboxState = null;
        String nameToShow  = null;
        Object obj = null;

        @Override
        public void run() {
            try {
                while ((obj = reader.readObject())!=null) {
                    System.out.println("Got an object from the server");
                    System.out.println(obj.getClass());

                    nameToShow = (String) obj;
                    obj = reader.readObject();
                    checkboxState = (boolean[])obj;
                    otherSeqsMap.put(nameToShow, checkboxState);
                    listVector.add(nameToShow);
                    incomingList.setListData(listVector);
                    changeSequence(checkboxState);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

            
        }
        
    }

    public class MyListSelectionListener implements ListSelectionListener {
        @Override
        public void valueChanged(ListSelectionEvent e) {
            // TODO Auto-generated method stub
            if (!e.getValueIsAdjusting()) {
                String selected = (String) incomingList.getSelectedValue();
                if (selected != null) {
                // now go to the map, and change the sequence
                boolean[] selectedState = (boolean[]) otherSeqsMap.get(selected);
                changeSequence(selectedState);
                sequencer.stop();
                buildTrackAndStart();
            
        }
     }
    }
   }
}

