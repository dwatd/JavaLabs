// Знайти найбільшу кількість речень заданого тексту, в яких є однакові слова. 
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in) ) {
            System.out.print("Enter your text: ");
            String inputText = scan.nextLine();

            StringBuffer text = new StringBuffer(inputText);
            
            // Try it out
            // System.out.println(text);
            // text.append(" How are you");
            // System.out.print(text);

        } catch (Exception error) {
            System.out.println(error.getMessage());
        }
    }
}