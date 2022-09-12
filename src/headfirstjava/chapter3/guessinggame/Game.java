package headfirstjava.chapter3.guessinggame;

import java.util.Scanner;

public class Game {
    private Player player1;
    private Player player2;
    private Player player3;

    private int guess1;
    private int guess2;
    private int guess3;

    private boolean playersAvailable = false;
    private boolean shouldContinue = true;

    private Scanner gameScanner;

    public Game(String player1, String player2, String player3) {
        this.player1 = new Player(player1);
        this.player2 = new Player(player2);
        this.player3 = new Player(player3);
        this.gameScanner = new Scanner(System.in);
        this.playersAvailable = true;
    }

    public Game(){
        this.gameScanner = new Scanner(System.in);
    }

    public void play() {
        showWelcomeMessage();
        if(!this.playersAvailable){
            requestForNamesOfPlayers();
        }

        do{ 
            int guessedNumber = (int) (Math.random() * 100);
            // System.out.println("The number is " + guessedNumber);
            takeGuesses();
            showResultsOfGame(guessedNumber);
            showScores();
            askIfShouldContinue();
            System.out.println(shouldContinue);
        }while(shouldContinue);  
        System.out.println("Thanks for playing!");
        this.gameScanner.close();
    }

    private void showWelcomeMessage() {
        System.out.println("Welcome to the guessing game!");
    }

    private void takeGuesses() {
        System.out.println("Enter your guesses");
        guess1 = player1.guess(this.gameScanner);
        guess2 = player2.guess(this.gameScanner);
        guess3 = player3.guess(this.gameScanner);
    }

    private void askIfShouldContinue(){
        System.out.println("Do you want to continue? (y/n)");
        String answer = this.gameScanner.nextLine();
        answer = this.gameScanner.nextLine();
        if(answer.equals("n")){
            this.shouldContinue = false;
        }
    }

    private void showResultsOfGame(int guessedNumber) {
        System.out.println("The number was " + guessedNumber);
        if(this.guess1 == guessedNumber){
            System.out.println(player1.name + " guessed it right!");
            player1.score++;
        }else{
            System.out.println(player1.name + " guessed it wrong!");
        }if(this.guess2 == guessedNumber){
            System.out.println(player2.name + " guessed it right!");
            player2.score++;
        }else{
            System.out.println(player2.name + " guessed it wrong!");
        }if(this.guess3 == guessedNumber){
            System.out.println(player3.name + " guessed it right!");
            player3.score++;
        }else{
            System.out.println(player3.name + " guessed it wrong!");
        }
        System.out.println("");
    }
    private void showScores(){
        System.out.println("Scores:");
        System.out.println(player1.name + ": " + player1.score);
        System.out.println(player2.name + ": " + player2.score);
        System.out.println(player3.name + ": " + player3.score);
    }

    private void requestForNamesOfPlayers(){
        System.out.println("Enter the names of the players:");
        String player1 = this.gameScanner.nextLine();
        String player2 = this.gameScanner.nextLine();
        String player3 = this.gameScanner.nextLine();

        this.player1 = new Player(player1);
        this.player2 = new Player(player2);
        this.player3 = new Player(player3);
    }
}
