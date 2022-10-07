package headfirstjava.chapter17;

import java.util.*;;

public class Song implements Comparable<Song> {
    private String title;
    private String artiste;
    private String rating;
    private String bpm;

    public Song(String title, String artiste, String rating, String bpm) {
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

    @Override
    public int compareTo(Song o) {
        return title.compareTo(o.getTitle());
    }

    /**
     * ArtisteComparator implements Comparator<String>
     */
    public static class ArtisteComparator implements Comparator<Song> {

        @Override
        public int compare(Song arg0, Song arg1) {
            return arg0.artiste.compareTo(arg1.artiste);
        }

    }

    @Override
    public int hashCode() {
        return getTitle().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        Song s = (Song) obj;
        return getTitle().equals(s.getTitle());
    }
}
