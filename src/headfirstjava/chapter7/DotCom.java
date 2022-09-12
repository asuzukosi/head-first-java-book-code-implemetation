package headfirstjava.chapter7;
import java.util.ArrayList;

public class DotCom {
    String name;
    ArrayList<String> cellLocations;
    boolean isSank = false;

    DotCom(String name) {
        this.name = name;
    }

    public void setCellLocations(ArrayList<String> loc) {
        cellLocations = loc;
    }

    public ArrayList<String> getCellLocations(){
        return cellLocations;
    }

    public String checkYourSelf(String guess) {
        String result = "miss";
        if (cellLocations.contains(guess)) {
            result = "hit " + name;
            cellLocations.remove(guess);
        }
        if (cellLocations.size() == 0) {
            result = "sank " + name;
            isSank = true;
        }
        return result;
    }
}
