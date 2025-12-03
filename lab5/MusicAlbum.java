package lab5;
import java.util.*;

public class MusicAlbum {
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

