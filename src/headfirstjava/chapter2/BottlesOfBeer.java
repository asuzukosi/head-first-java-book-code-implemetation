package headfirstjava.chapter2;

/* This game is menat to simultate the 99 bottles of beer
 * childrens game
 */
public class BottlesOfBeer {
    public static void main(String[] args) {
        int numBottles = 99;
        String name = "bottles";

        while(numBottles > 0){
            if(numBottles == 1){
                name = "bottle";
            }

            System.out.println(numBottles + " " + name + " of beer on the wall");
            System.out.println(numBottles + " " + name + " of beer");
            System.out.println("Take one down");
            System.out.println("Pass it arround");
            numBottles--;

            if(numBottles > 0){
                System.out.println(numBottles + " " + name + " of beer on the wall");

            } else {
                System.out.println("There are no bottles of beer");
            }
            
        }
    }
}
