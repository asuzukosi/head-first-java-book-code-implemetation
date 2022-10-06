package headfirstjava.chapter17;

public class GenerifieldPrinterTester {
    public static void main(String[] args) {
        Song song = new Song("hello", "hi", "23", "2");
        Song song2 = new Song("we", "will", "rock", "you");

        GenerifiedPrinter<Song> songGenerifiedPrinter = new GenerifiedPrinter<Song>(song);
        songGenerifiedPrinter.print(song2);

        GenerifiedPrinter<String> stringGenerifiedPrinter = new GenerifiedPrinter<String>("start: ");
        stringGenerifiedPrinter.print("shit");
    }
}
