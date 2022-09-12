package headfirstjava.chapter2;

public class Shuffle {
    public static void main(String[] args) {
        int x = 3;
        while(x > 0){
            if(x > 2){
                System.out.print("a");
            }
            if(x == 2){
                System.out.print("b c");
            }
            if(x == 1){
                System.out.print("d");
                x = x - 1;
            }else{
                x = x -1;
                System.out.print("-");
            }
            
        }

        System.out.println("");
    }
}
