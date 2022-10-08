package headfirstjava.chapter17;
import java.io.*;
import java.util.*;

import headfirstjava.chapter17.Song.ArtisteComparator;

public class SongCounter {
    static ArrayList<Song> data = new ArrayList<Song>();
    static File file;

    public static void main(String[] args) {
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(reader);
        String fileName = null;

        try {
            System.out.println("Enter the name of the file you wish to read songs from");
            fileName = br.readLine();
        } catch (Exception e) {
            fileName = "SongList.txt";
        }

        readFile(fileName);
        LoadFile();
        Collections.sort(data);
        System.out.println(data);
        ArtisteComparator comparator = new ArtisteComparator();
        Collections.sort(data, comparator);
        System.out.println(data);
        TreeSet<Song> set = new TreeSet<Song>();
        set.addAll(data);
        System.out.println(set);
        
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
