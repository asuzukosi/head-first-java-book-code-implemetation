package headfirstjava.chapter17;
import java.io.*;
import java.util.*;

public class SongCounter {
    static ArrayList<Song> data = new ArrayList<Song>();
    static File file;

    public static void main(String[] args) {
        readFile("SongList.txt");
        LoadFile();
        System.out.println(data);
        
    }
    public static void readFile(String filename) {
        file = new File(filename);
    }

    public static void LoadFile() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line=reader.readLine())!=null) {
                addSong(line);
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void addSong(String line) {
        String[] songAndArtist = line.split("/");
        String title = songAndArtist[0];
        String artiste = songAndArtist[1];
        String rating = songAndArtist[2];
        String bpm = songAndArtist[3];

        Song song = new Song(title, artiste, rating, bpm);
        data.add(song);

    }
}
