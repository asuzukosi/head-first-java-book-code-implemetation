package headfirstjava.chapter3.guessinggame;

import java.util.Scanner;

public class Player {
    public int score;
    public String name;


    public Player(String name) {
        this.name = name;
    }

    public int guess(Scanner scanner) {
        System.out.println(name + " enter a guess for a number between 0 and 100:");
        int guess = scanner.nextInt();
        return guess;

    }
}
