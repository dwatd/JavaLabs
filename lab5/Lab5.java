package lab5;
import java.util.List;

public class Lab5 {
    public static void main(String[] args) {
        try {
            MusicAlbum album = new MusicAlbum();

            album.addComposition(new RockComposition("Thunder Road", 290));
            album.addComposition(new PopComposition("Good Goodbye", 223));
            album.addComposition(new ClassicalComposition("Dawn", 159));
            album.addComposition(new JazzComposition("Autumn Leaves", 391));
            album.addComposition(new PopComposition("Mantra", 137));
            album.addComposition(new RockComposition("Money", 383));

            System.out.println("Album before sorting:");
            album.printAlbum();

            album.sortByStyle();
            System.out.println("\nAlbum after sorting by style:");
            album.printAlbum();

            System.out.println("\nTotal duration: " + album.getTotalDuration() + " seconds");

            System.out.println("\nTracks with given duration:");
            List<Composition> found = album.findByDurationRange();
            for (Composition c : found) {
                System.out.println(c);
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
