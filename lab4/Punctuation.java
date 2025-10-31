// Клас для представлення розділових знаків
public class Punctuation {
    private final char symbol;

    public Punctuation(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }

    public StringBuffer toStringBuffer() {
        return new StringBuffer().append(symbol);
    }

    @Override
    public String toString() {
        return String.valueOf(symbol);
    }
}
