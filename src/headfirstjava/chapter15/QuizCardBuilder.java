package headfirstjava.chapter15;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.io.*;



public class QuizCardBuilder {

    private JPanel panel;
    private JFrame frame;
    private JTextArea question;
    private JTextArea answer;
    private ArrayList<QuizCard> cards;

    public static void main(String[] args) {
        QuizCardBuilder qcb = new QuizCardBuilder();
        qcb.go();
    }
    public void go() {
        frame = new JFrame("Quiz Card Builder");

        panel = new JPanel();
        Font bigFont = new Font("sanserif", Font.BOLD, 24);

        // set up question text area and scroller
        question = new JTextArea(6,20);
        question.setLineWrap(true);
        question.setWrapStyleWord(true);
        question.setFont(bigFont);


        JScrollPane qScroller = new JScrollPane(question);
        qScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        qScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        // set up answer text area ans scroller
        answer = new JTextArea(6,20);
        answer.setLineWrap(true);
        answer.setWrapStyleWord(true);
        answer.setFont(bigFont);

        JScrollPane aScroller = new JScrollPane(answer);
        aScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        aScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        JButton nextButton = new JButton("Next Card");
        cards = new ArrayList<QuizCard>();
        JLabel qLabel = new JLabel("Question:");
        JLabel aLabel = new JLabel("Answer:");

        panel.add(qLabel);
        panel.add(qScroller);
        panel.add(aLabel);
        panel.add(aScroller);
        panel.add(nextButton);
        nextButton.addActionListener(new NextCardListener());
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem newMenuItem = new JMenuItem("New");
        JMenuItem saveMenuItem = new JMenuItem("Save");

        newMenuItem.addActionListener(new NewMenuListener());
        saveMenuItem.addActionListener(new SaveMenuListener());

        fileMenu.add(newMenuItem);
        fileMenu.add(saveMenuItem);

        menuBar.add(fileMenu);
        frame.setJMenuBar(menuBar);
        frame.getContentPane().add(BorderLayout.CENTER, panel);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(550, 600);
        frame.setVisible(true);   
    }
    
    
    private class NextCardListener implements ActionListener {
        public void actionPerformed(ActionEvent ev) {
        // add the current card to the list and clear the text areas
        QuizCard card = new QuizCard(question.getText(), answer.getText());
        cards.add(card);
        clearCard();
        }
    }

    private class SaveMenuListener implements ActionListener {
        public void actionPerformed(ActionEvent ev) {
            QuizCard card = new QuizCard(question.getText(), answer.getText());
            cards.add(card);

            JFileChooser ﬁleSave = new JFileChooser();
            ﬁleSave.showSaveDialog(frame);
            saveFile(ﬁleSave.getSelectedFile());
        }
    }

    private class NewMenuListener implements ActionListener {
        public void actionPerformed(ActionEvent ev) {
        // clear out the card list, and clear out the text areas
        cards.clear();
        clearCard();
        }
    }

    private void saveFile(File ﬁle) {
        // iterate through the list of cards, and write each one out to a text ﬁle
        // in a parseable way (in other words, with clear separations between parts)
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(ﬁle));
            for(QuizCard card:cards) {
                writer.write(card.getQuestion() + "/");
                writer.write(card.getAnswer() + "\n");
            }
            writer.close();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    /*
     * This is the method to clear the previous card details
     * and set the focus on the question text area
     */
    private void clearCard() {
        question.setText("");
        answer.setText("");
        question.requestFocus();
    }
}
