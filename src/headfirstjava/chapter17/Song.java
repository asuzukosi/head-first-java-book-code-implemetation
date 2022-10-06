package headfirstjava.chapter17;

public class Song {
    String title;
    String artiste;
    String rating;
    String bpm;

    public Song(String title, String artiste, String rating, String bpm){
        this.title = title;
        this.artiste = artiste;
        this.rating = rating;
        this.bpm = bpm;
    }

    public String getTitle() {
        return this.title;
    }

    public String getArtiste() {
        return this.artiste;
    }

    public String getRating() {
        return this.rating;
    }

    public String getBpm() {
        return this.bpm;
    }

    @Override
    public String toString() {
        return this.title;
    }
}
