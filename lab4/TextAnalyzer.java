import java.util.*;

// Клас, який виконує аналіз тексту. Тобто знаходить слова, які зустрічаються в найбільшій кількості речень
public class TextAnalyzer {

    public void findMostFrequentWords(Text text) {
        List<Sentence> sentences = text.getSentences();
        Map<StringBuffer, Set<Integer>> wordMap = new HashMap<>();

        // 1. Збирає всі слова з кожного речення
        for (int i = 0; i < sentences.size(); i++) {
            for (Word w : sentences.get(i).getWords()) {
                StringBuffer lower = new StringBuffer(w.getValue().toString().toLowerCase());
                boolean found = false;
                for (StringBuffer key : wordMap.keySet()) {
                    if (key.toString().equals(lower.toString())) {
                        wordMap.get(key).add(i);
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    Set<Integer> s = new HashSet<>();
                    s.add(i);
                    wordMap.put(lower, s);
                }
            }
        }

        // 2. Знаходить максимальну кількість речень, у яких зустрічається хоч одне слово
        int max = 0;
        for (Set<Integer> set : wordMap.values()) {
            if (set.size() > max) max = set.size();
        }

        // 3. Збирає всі слова, що мають цю максимальну кількість
        List<StringBuffer> result = new ArrayList<>();
        for (Map.Entry<StringBuffer, Set<Integer>> entry : wordMap.entrySet()) {
            if (entry.getValue().size() == max) result.add(entry.getKey());
        }

        System.out.println("\nWord(s) appearing in the most sentences (" + max + "):");
        for (StringBuffer w : result) {
            System.out.print(w + " ");
        }
        System.out.println();
    }
}
