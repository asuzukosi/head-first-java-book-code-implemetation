package headfirstjava.chapter3.cinema;

public class MovieTestDrive {
    public static void main(String[] args) {
        Movie citizenKane = new Movie("Citizen Kane", "drama",4);
        Movie starwarsANewHope = new Movie("Star Wars: A New Hope", "scifi",5);

        System.out.println(citizenKane.title + " is rated " + citizenKane.rating + " and is a " + citizenKane.genre + " movie.");
        citizenKane.playIt();

        System.out.println(starwarsANewHope.title + " is rated " + starwarsANewHope.rating + " and is a " + starwarsANewHope.genre + " movie.");
        starwarsANewHope.playIt();
    }
}
