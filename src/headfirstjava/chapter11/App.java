package headfirstjava.chapter11;
import java.util.Date;
import java.util.Calendar;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        Singleton mySingleton = Singleton.instance;
        mySingleton.message();
        System.out.println(Math.PI);
        testingMath();
        testingOutAutoUnboxing();

        int a = 5;
        Integer b = 10;
        int c = addNumbers(a, b);

        System.out.println(c);

        int myNumber = Integer.parseInt("6");
        System.out.println("My number is " + myNumber);

        double myDouble = 45.56;
        String myDoubleString = Double.toString(myDouble);
        System.out.println(myDoubleString);

        testingOutStringFormatting();   


        Calendar myCal = Calendar.getInstance();
        myCal.set(2020, 3, 15, 12, 23);
        long day1 = myCal.getTimeInMillis();
        day1 += 100 * 60 * 60;
        myCal.setTimeInMillis(day1);

        // get the hour of the day
        System.out.println(myCal.get(Calendar.HOUR_OF_DAY));

        // add 35 days
        myCal.add(Calendar.DATE, 35);
        System.out.println(myCal.getTime());   

        myCal.roll(Calendar.DATE, 35);
        System.out.println(myCal.getTime());

    }

    public static void testingMath(){
        int randomNumber = (int)(Math.random() * 6); // random number between 0 - 5
        System.out.println(randomNumber);

        // get absolute value for int and double
        // method is overloaded so same method works for both
        int x = Math.abs(-23);
        double y = Math.abs(-5647.903);

        System.out.println(x);
        System.out.println(y);

        // round a number to the nearest integer
        long roundedValue = Math.round(8.73);
        System.out.println(roundedValue);

        int[] data = {3, 5, 7, 1, 2};
        System.out.println("Minimum value is : " + data[getMinIndexInList(data)]);
        System.out.println("Maximum value is : " + data[getMaxIndexInList(data)]);
    }

    public static int getMinIndexInList(int[] values){
        int minimumValueIndex = 0;
        for(int i = 1; i < values.length; i++){

           if(values[i] == Math.min(values[minimumValueIndex], values[i])){
                minimumValueIndex = i;
           }
        }
        return minimumValueIndex;
    }

    public static int getMaxIndexInList(int[] values){
        int minimumValueIndex = 0;
        for(int i = 1; i < values.length; i++){

           if(values[i] == Math.max(values[minimumValueIndex], values[i])){
                minimumValueIndex = i;
           }
        }
        return minimumValueIndex;
    }

    public static void testingOutAutoUnboxing(){
        ArrayList<Integer> mylist = new ArrayList<Integer>();
        mylist.add(3);
        System.out.println(mylist.get(0));
    }

    public static Integer addNumbers(Integer a, int b){
        return a + b;
    }

    public static void testingOutStringFormatting() {
        String s = String.format("%,d", 10000000);
        System.out.println(s);

        String m = String.format("I've got %,12.2f bugs to fix", 57275.369869);
        System.out.println(m);

        String date = String.format("Today's date is : %tA, %<tB %<td", new Date());
        System.out.println(date);
    }
}
