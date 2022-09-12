package headfirstjava.chapter2;

/*
 * the program makes three lists of words, then randomly picks one word
 * from each of the three lists, and prints out the result.
 */
public class PhraseOMatic {
    public static void main(String[] args) {

        // create an array of lists of words to pick from
        String[] wordListOne = {"24/7","multi-Tier","30,000 foot",
            "B-to-B","win-win","front-end", "web-based","pervasive", "smart", "six-sigma","critical-path", "dynamic"};
            
        String[] wordListTwo = {"empowered", "sticky","value-added", "oriented", "centric", "distributed",
                                "clustered", "branded","outside-the-box", "positioned","networked", "focused", "leveraged", "aligned",
                                "targeted", "shared", "cooperative", "accelerated"};

        String[] wordListThree = {"process", "tipping-point", "solution", "architecture", "core competency",
                                "strategy", "mindshare", "portal", "space", "vision","paradigm", "mission"};


        // get the length of each list and store it in a variable
        int listOne = wordListOne.length;
        int listTwo = wordListTwo.length;
        int listThree = wordListThree.length;

        // pick a random number between 0 and the length of the list
        int randomWord = (int) (Math.random() * listOne);
        int randomWordTwo = (int) (Math.random() * listTwo);
        int randomWordThree = (int) (Math.random() * listThree);

        // print out the result
        System.out.println("What we need is a " + wordListOne[randomWord] + " " + wordListTwo[randomWordTwo] + " " + wordListThree[randomWordThree]);

    }
}
