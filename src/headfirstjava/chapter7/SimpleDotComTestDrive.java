package headfirstjava.chapter7;

import java.util.ArrayList;

public class SimpleDotComTestDrive {
    public static void main(String[] args) {
        SimpleDotCom dot = new SimpleDotCom();
        ArrayList<String> locations = new ArrayList<String>();
        locations.add("2");
        locations.add("3");
        locations.add("4");

        dot.setLocationCells(locations);
        String testResult = "failed";

        // Ensure set locations is working
        if(dot.getLocationCells().contains("2") == locations.contains("2")) {
            testResult = "passed";
        }

        testResult = "failed";

        // test check yourself
        String userGuess = "2";

        dot.checkYourSelf(userGuess);
        if (dot.numOfHits == 1) {
            testResult = "passed";
        }

        System.out.println(testResult);
    }
}
