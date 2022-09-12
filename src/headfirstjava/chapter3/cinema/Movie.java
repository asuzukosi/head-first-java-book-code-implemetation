package headfirstjava.chapter3.cinema;

public class Movie {
    public int rating;
    public String title;
    public String genre;

    public Movie(String title, String genre, int rating) {
        this.title = title;
        this.genre = genre;
        this.rating = rating;
    }

    public void playIt(){
        System.out.println("Playing " + title);
    }
}
