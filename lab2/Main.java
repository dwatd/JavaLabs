// Знайти найбільшу кількість речень заданого тексту, в яких є однакові слова. 
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in) ) {
            System.out.print("Enter your text: ");
            String inputText = scan.nextLine();

            StringBuffer text = new StringBuffer(inputText);

            findTheMostFrequentWords(text);

        } catch (Exception error) {
            System.out.println(error.getMessage());
        }
    }

    private static void findTheMostFrequentWords(StringBuffer text) {

        // 1. Розбити текст на речення
        // 2. Знайти всі унікальні слова з тексту
        // 3. Створити матрицю: рядки = слова, стовпці = речення 
        // 4. Ітерувати через кожне речення і заповнити матрицю
        // 5. Порахувати суму по рядках

        // 1
        List<StringBuffer> sentences = new ArrayList<>();
        StringBuffer current = new StringBuffer();

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            current.append(ch);
            if (ch == '.' || ch == '!' || ch == '?') {
                sentences.add(new StringBuffer(current.toString().trim()));
                current.setLength(0);
            }
        }
        if (current.length() > 0) {
            sentences.add(new StringBuffer(current.toString().trim()));
        }

        // 2
        List<StringBuffer> allWords = new ArrayList<>();

        for (StringBuffer s : sentences) {
            StringBuffer word = new StringBuffer();
            for (int i = 0; i < s.length(); i++) {
                char c = Character.toLowerCase(s.charAt(i));
                if (Character.isLetterOrDigit(c)) {
                    word.append(c);
                } else if (word.length() > 0) {
                    addUniqueWord(allWords, word);
                    word.setLength(0);
                }
            }
            if (word.length() > 0) {
                addUniqueWord(allWords, word);
            }
        }

        // 3
        int[][] matrix = new int[allWords.size()][sentences.size()];

        // 4
        for (int i = 0; i < sentences.size(); i++) {
            StringBuffer s = new StringBuffer(sentences.get(i).toString().toLowerCase());
            for (int j = 0; j < allWords.size(); j++) {
                String w = allWords.get(j).toString();
                if (containsWord(s, w)) {
                    matrix[j][i] = 1;
                }
            }
        }

        // 5
        List<StringBuffer> maxWords = new ArrayList<>();
        int max = 0;

        for (int i = 0; i < allWords.size(); i++) {
            int sum = 0;
            for (int j = 0; j < sentences.size(); j++) {
                sum += matrix[i][j];
            }
            if (sum > max) {
                max = sum;
                maxWords.clear();
                maxWords.add(allWords.get(i));
            } else if (sum == max) {
                maxWords.add(allWords.get(i));
            }
        }

        // Результат
        System.out.println("\nWord matrix (1 = word appears in sentence):");
        for (int i = 0; i < allWords.size(); i++) {
            System.out.print(allWords.get(i) + ":\t");
            for (int j = 0; j < sentences.size(); j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        System.out.print("\nWord(s) that appear in the most sentences (" + max + "): ");
        for (int i = 0; i < maxWords.size(); i++) {
            System.out.print(maxWords.get(i));
            if (i < maxWords.size() - 1) System.out.print(", ");
        }
        System.out.println(".");
    }

    // Додавання слова, якщо його ще немає
    private static void addUniqueWord(List<StringBuffer> list, StringBuffer word) {
        for (StringBuffer w : list) {
            if (w.toString().equals(word.toString())) {
                return;
            }
        }
        list.add(new StringBuffer(word.toString()));
    }

    // Перевірка чи є слово в реченні
    private static boolean containsWord(StringBuffer sentence, String word) {
        StringBuffer current = new StringBuffer();
        word = word.toLowerCase();

        for (int i = 0; i < sentence.length(); i++) {
            char c = Character.toLowerCase(sentence.charAt(i));
            if (Character.isLetterOrDigit(c)) {
                current.append(c);
            } else if (current.length() > 0) {
                if (current.toString().equals(word)) return true;
                current.setLength(0);
            }
        }
        return current.toString().equals(word);
    }
}