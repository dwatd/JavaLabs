// C13 = 17 % 13 = 4
/* 
 * Визначити ієрархію музичних композицій. 
 * Записати на диск альбом. Порахувати тривалість альбому. 
 * Провести перестановку композицій диска на основі приналежності до стилю. 
 * Знайти композицію, що відповідає заданому діапазону довжини треків.
*/
import java.util.*;

/**
 * Клас, що представляє музичну композицію
 */
abstract class Composition {
    protected String title;
    protected int duration; // тривалість в секундах
    protected String style;

    public Composition(String title, int duration, String style) {
        if (duration <= 0) {
            throw new IllegalArgumentException("Duration must be positive.");
        }
        this.title = title;
        this.duration = duration;
        this.style = style;
    }

    public String getTitle() {
        return title;
    }

    public int getDuration() {
        return duration;
    }

    public String getStyle() {
        return style;
    }

    @Override
    public String toString() {
        return title + " (" + duration + " sec, " + style + ")";
    }
}

/**
 * Клас для опису рок музики.
 */
class RockComposition extends Composition {
    public RockComposition(String title, int duration) {
        super(title, duration, "Rock");
    }
}

/**
 * Клас для опису поп музики
 */
class PopComposition extends Composition {
    public PopComposition(String title, int duration) {
        super(title, duration, "Pop");
    }
}

/**
 * Клас для опису класичної музики
 */
class ClassicalComposition extends Composition {
    public ClassicalComposition(String title, int duration) {
        super(title, duration, "Classical");
    }
}

/**
 * Клас для опису джаз музики
 */
class JazzComposition extends Composition {
    public JazzComposition(String title, int duration) {
        super(title, duration, "Jazz");
    }
}

/**
 * Клас для опису альбому, який складається з декількох музичних композицій
 */
class MusicAlbum {
    private List<Composition> tracks = new ArrayList<>();

    /** Додавання композиції до альбому */
    public void addComposition(Composition comp) {
        if (comp == null) {
            throw new NullPointerException("Composition cannot be null.");
        }
        tracks.add(comp);
    }

    /** Підрахунок загальної довжини альбому */
    public int getTotalDuration() {
        return tracks.stream().mapToInt(Composition::getDuration).sum();
    }

    /** Сортування композицій за стилем у алфавітному порядку */
    public void sortByStyle() {
        tracks.sort(Comparator.comparing(Composition::getStyle));
    }

    /** Знаходить композиції з тривалістю в заданому діапазоні */
    public List<Composition> findByDurationRange() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter minimum duration (sec): ");
        int min = scanner.nextInt();

        System.out.print("Enter maximum duration (sec): ");
        int max = scanner.nextInt();
        
        if (min < 0 || max < 0 || min > max) {
            throw new IllegalArgumentException("Invalid duration range.");
        }
        List<Composition> result = new ArrayList<>();
        for (Composition c : tracks) {
            if (c.getDuration() >= min && c.getDuration() <= max) {
                result.add(c);
            }
        }
        return result;
    }

    /** Вивід всіх композицій альбому */
    public void printAlbum() {
        for (Composition c : tracks) {
            System.out.println(c);
        }
    }
}

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

