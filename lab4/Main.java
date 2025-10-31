import java.util.Scanner;

public class Main {
    /**
     * Здійснює зчитування тексту від користувача, створює об’єкт тексту
     * та виконує аналіз для пошуку найчастіше вживаних слів.
     */
    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            System.out.print("Enter your text: ");
            String input = scan.nextLine();

            StringBuffer textBuffer = new StringBuffer(input);

            Text text = new Text(textBuffer);
            TextAnalyzer analyzer = new TextAnalyzer();
            analyzer.findMostFrequentWords(text);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}


