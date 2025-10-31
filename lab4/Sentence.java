import java.util.ArrayList;
import java.util.List;

// Клас для представлення речення (слова + розділові знаки)
public class Sentence {
    // Список елементів речення. Кожен елемент — це або об’єкт Word, або Punctuation.
    private final List<Object> elements = new ArrayList<>(); 

    public Sentence(StringBuffer rawSentence) {
        // Розбиваємо текст на токени (слова і розділові знаки), розділені пробілами або табуляціями.
        String[] tokens = rawSentence.toString().trim().split("\\s+");

        for (String token : tokens) {
            StringBuffer buffer = new StringBuffer(token); // поточний токен
            StringBuffer cleanWord = new StringBuffer(); // тимчасовий буфер для накопичення літер

            // Розділення літер та пунктуації
            for (int i = 0; i < buffer.length(); i++) {
                char c = buffer.charAt(i);
                if (Character.isLetterOrDigit(c)) {
                    cleanWord.append(c);
                } else {
                    if (cleanWord.length() > 0) {
                        elements.add(new Word(new StringBuffer(cleanWord)));
                        cleanWord.setLength(0);
                    }
                    elements.add(new Punctuation(c));
                }
            }
            if (cleanWord.length() > 0) {
                elements.add(new Word(new StringBuffer(cleanWord)));
            }
        }
    }

    // Повертає всі слова з речення (без пунктуації).
    public List<Word> getWords() {
        List<Word> words = new ArrayList<>();
        for (Object e : elements) {
            if (e instanceof Word) {
                words.add((Word) e);
            }
        }
        return words;
    }
    
    // Перетворює речення назад у StringBuffer.
    public StringBuffer toStringBuffer() {
        StringBuffer sb = new StringBuffer();
        for (Object e : elements) {
            if (e instanceof Word) sb.append(((Word) e).toStringBuffer()).append(" ");
            else sb.append(((Punctuation) e).toStringBuffer()).append(" ");
        }
        return sb;
    }

    @Override
    public String toString() {
        return toStringBuffer().toString().trim();
    }
}
