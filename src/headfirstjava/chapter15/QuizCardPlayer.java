package headfirstjava.chapter15;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.io.*;


public class QuizCardPlayer {

    private  JTextArea display;
    private ArrayList<QuizCard> cardList;
    private QuizCard currentCard;
    private int currentCardIndex;
    private JFrame frame;
    private JButton nextButton;
    private boolean isShowAnswer;

    public static void main(String[] args) {
        QuizCardPlayer qcp = new QuizCardPlayer();
        qcp.go();
    }

    public void go() {
        // GUI implementation
        frame = new JFrame("Quiz Card Player");
        JPanel mainPanel = new JPanel();
        Font bigFont = new Font("sanserif", Font.BOLD, 24);

        display = new JTextArea(10,20);
        display.setFont(bigFont);
        display.setLineWrap(true);
        display.setEditable(false);

        JScrollPane qScroller = new JScrollPane(display);
        qScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        qScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        nextButton = new JButton("Show Question");
        mainPanel.add(qScroller);
        mainPanel.add(nextButton);
        nextButton.addActionListener(new NextCardListener());
    
        JMenuBar menuBar = new JMenuBar();
        JMenu ﬁleMenu = new JMenu("File");
        JMenuItem loadMenuItem = new JMenuItem("Load card set");
        loadMenuItem.addActionListener(new OpenMenuListener());
        ﬁleMenu.add(loadMenuItem);
        menuBar.add(ﬁleMenu);
        frame.setJMenuBar(menuBar);
        frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(640,500);
        frame.setVisible(true);
    
    }

    class NextCardListener implements ActionListener {
        public void actionPerformed(ActionEvent ev) {
        // if this is a question, show the answer, otherwise show next question
        // set a ﬂag for whether we’re viewing a question or answer

        if(isShowAnswer){
            display.setText(currentCard.getAnswer());
            nextButton.setText("Next Card");
            isShowAnswer = false;
        }else{
            if (currentCardIndex < cardList.size()) {
                showNextCard();
            }else{
                // there are no more cards!
                display.setText("That was last card");
                nextButton.setEnabled(false);
            }
        }

        }
    }

    class OpenMenuListener implements ActionListener {
        public void actionPerformed(ActionEvent ev) {
            // bring up a ﬁle dialog box
            // let the user navigate to and choose a card set to open
            JFileChooser ﬁleOpen = new JFileChooser();
            ﬁleOpen.showOpenDialog(frame);
            loadFile(ﬁleOpen.getSelectedFile());
        }
    }

    private void loadFile(File ﬁle) {
        // must build an ArrayList of cards, by reading them from a text ﬁle
        // called from the OpenMenuListener event handler, reads the ﬁle one line at a time
        // and tells the makeCard() method to make a new card out of the line
        // (one line in the ﬁle holds both the question and answer, separated by a "/")
        cardList = new ArrayList<QuizCard>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(ﬁle));
            String line = null;
            while ((line = reader.readLine()) != null){
                makeCard(line);
            }
            reader.close();
        } catch (Exception e) {
            System.out.println("Could not read card file");
            e.printStackTrace();
        }

        // now time to start by showing the ﬁrst card
        showNextCard();
    }

    private void makeCard(String lineToParse) {
        // called by the loadFile method, takes a line from the text ﬁle
        // and parses into two pieces—question and answer—and creates a new QuizCard
        // and adds it to the ArrayList called CardList
        String[] result = lineToParse.split("/");
        QuizCard card = new QuizCard(result[0], result[1]);
        cardList.add(card);
        System.out.println("made a card");
    }

    private void showNextCard() {
        currentCard = cardList.get(currentCardIndex);
        currentCardIndex++;
        display.setText(currentCard.getQuestion());
        nextButton.setText("Show Answer");
        isShowAnswer = true;
    }
 }

