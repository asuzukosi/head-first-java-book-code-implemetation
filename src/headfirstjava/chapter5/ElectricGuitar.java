package headfirstjava.chapter5;

public class ElectricGuitar {
    String band;
    int numOfPickups;
    boolean rockStarUsesIt;


    public ElectricGuitar(String band, int numOfPickups, boolean rockStarUsesIt){
        this.band = band;
        this.numOfPickups = numOfPickups;
        this.rockStarUsesIt = rockStarUsesIt;
    }

    public String getBand(){
        return this.band;
    }
    public void setBand(String band){
        this.band = band;
    }

    public int getNumOfPickups(){
        return this.numOfPickups;
    }
    public void setNumOfPickups(int numOfPickups){
        this.numOfPickups = numOfPickups;
    }

    public boolean getRockStarUsesIt(){
        return this.rockStarUsesIt;
    }
    public void setRockStarUsesIt(boolean rockStarUsesIt){
        this.rockStarUsesIt = rockStarUsesIt;
    }
}
