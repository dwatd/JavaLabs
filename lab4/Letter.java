// Клас для представлення однієї літери (символу) у тексті
public class Letter {
    private final char value; 
    
    public Letter(char value) {
        this.value = value;
    }

    public char getValue() {
        return value;
    }

    public StringBuffer toStringBuffer() {
        return new StringBuffer().append(value);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
