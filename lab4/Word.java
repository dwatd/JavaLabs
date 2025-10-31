import java.util.ArrayList;
import java.util.List;

// Клас, який представляє слово
public class Word {
    private final List<Letter> letters = new ArrayList<>();

    public Word(StringBuffer word) {
        for (int i = 0; i < word.length(); i++) {
            letters.add(new Letter(word.charAt(i)));
        }
    }

    public StringBuffer getValue() {
        StringBuffer sb = new StringBuffer();
        for (Letter l : letters) {
            sb.append(l.getValue());
        }
        return sb;
    }

    public StringBuffer toStringBuffer() {
        return getValue();
    }

    @Override
    public String toString() {
        return getValue().toString();
    }
}


