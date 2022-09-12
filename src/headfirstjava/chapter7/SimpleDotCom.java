package headfirstjava.chapter7;

import java.util.ArrayList;

public class SimpleDotCom {
    private ArrayList<String> locationCells;
    public int numOfHits;

    public void setLocationCells(ArrayList<String> loc) {
        locationCells = loc;
    }

    public ArrayList<String> getLocationCells() {
        return locationCells;
    }

    public String checkYourSelf(String guess) {
        // set defualt result to miss
        String result = "miss";

        // check if guess is in locationCells
        if(locationCells.contains(guess)) {
            result = "hit";

            // increase num of hits and remove the guess from locationCells
            numOfHits++;
            locationCells.remove(guess);
        }
        // if the size of locationCells is 0, then the dot com is sunk
        if(numOfHits == locationCells.size()) {
            result = "kill";
        }
        return result;
    }

}
