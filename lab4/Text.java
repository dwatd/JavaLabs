import java.util.ArrayList;
import java.util.List;

// Клас який представляє повний текст, який складається з кількох речень
public class Text {
    private final List<Sentence> sentences = new ArrayList<>();

     /*
     * Конструктор класу.
     * Приймає текст і:
     * 1. замінює послідовності пробілів/табуляцій на один пробіл;
     * 2. розбиває текст на окремі речення за розділовими знаками;
     * 3. створює об’єкти Sentence і додає їх до списку.
     */
    public Text(StringBuffer input) {
        StringBuffer cleaned = new StringBuffer(input.toString().replaceAll("[\\t\\s]+", " ").trim());

        String[] rawSentences = cleaned.toString().split("(?<=[.!?])");
        for (String raw : rawSentences) {
            if (!raw.trim().isEmpty()) {
                sentences.add(new Sentence(new StringBuffer(raw.trim())));
            }
        }
    }

    public List<Sentence> getSentences() {
        return sentences;
    }

    public StringBuffer toStringBuffer() {
        StringBuffer sb = new StringBuffer();
        for (Sentence s : sentences) {
            sb.append(s.toStringBuffer()).append(" ");
        }
        return sb;
    }

    @Override
    public String toString() {
        return toStringBuffer().toString().trim();
    }
}
