package headfirstjava.chapter7;
import java.util.Scanner;
import java.util.ArrayList;

public class GameHelper {
    private static final Scanner sc = new Scanner(System.in);

    public static ArrayList<String> generatePositions() {
        String[] vertical = {"a", "b", "c", "d", "e", "f", "g"};
        String[] horizontal = {"1", "2", "3", "4", "5", "6", "7"};

        // Generate number either 0 or 1
        int order = (int)Math.round( Math.random());
        int startPostionVertical = (int)(Math.random() * 4);
        int startPostionHorizontal = (int)(Math.random() * 4);
        ArrayList<String> positions = new ArrayList<String>();

        // arrange the positions in vertical order
        if(order==0){
            for(int i=startPostionVertical; i < startPostionVertical + 3; i++){
                positions.add(vertical[i] + horizontal[startPostionHorizontal]);
            }
        }
        // arrange the position in horizontal order
        else {
            for(int i=startPostionHorizontal; i < startPostionHorizontal + 3; i++){
                positions.add(vertical[startPostionVertical] + horizontal[i]);
            }
        }
        return positions;
    }

    public static String getUserInput(String message){
        System.out.println(message);
        String result = sc.nextLine();
        return result;
    }

    public static void closeScanner(){
        sc.close();
    }
}
