package headfirstjava.chapter7;
import java.util.ArrayList;

public class SinkADotCom {
    static DotCom[] dotComs = new DotCom[3];
    static int numTries = 0;

    public static void main(String[] args) {
        setupGame();
        playGame();
        outroMessage();
    }

    /*
     * Now that the game is over 
     * print the outro message
     */
    public static void outroMessage() {
        System.out.println("All DotComs have been sunk");
        System.out.println("Game Over");
        System.out.println("You took " + numTries + " tries");
        System.out.println("You crazy Mofo!");
        GameHelper.closeScanner();
    }

    /*
     * This method checks if all the dotcoms have been sunk
     * it loops through all dot coms and checks the isSank 
     * instance variable
     */
    public static boolean checkIfAllDotComsHaveSank(){
        for(DotCom dotCom : dotComs){
            if(!dotCom.isSank){
                return true;
            }
        }
        return false;
    }

    /*
     * Setup the game by creating the dotcoms and giving them 
     * their start positions
     */
    public static void setupGame() {
        System.out.println("Setting up the game...");
        for(int i = 0; i < dotComs.length; i++){
            String response = GameHelper.getUserInput("Enter the name of the DotCom " + (i+1));
            DotCom dotCom = new DotCom(response);
            ArrayList<String> positions = GameHelper.generatePositions();
            dotCom.setCellLocations(positions);
            dotComs[i] = dotCom;
        }
        System.out.println("Game is set up");
    }
    /*
     * Whiel all the dot coms are not sunk, keep playing the game
     * get the input from the user
     * loop through all the dotcoms with that input
     * if a dot com has not yet been sunk, check if the input is a hit, miss or kill
     * print the result
    */
    public static void playGame() {
        while(checkIfAllDotComsHaveSank()){
            String userInput = GameHelper.getUserInput("Enter a guess");
            for(DotCom dotCom: dotComs) {
                if(!dotCom.isSank) {
                    String result = dotCom.checkYourSelf(userInput);
                    System.out.println(result);
                }
            }
            numTries++;
        }
    }
}
