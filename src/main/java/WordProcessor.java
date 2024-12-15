import java.util.*;

public class WordProcessor {
    public static void main(String[] args) {
        String[] words = {"Клубника", "Ежевика", "Клубника", "Голубика", "Ежевика", "Клюква",
                "Клубника", "Арбуз", "Голубика", "Клюква", "Арбуз", "Брусника", "Ежевика"};

        // для подсчета количества вхождений каждого слова
        Map<String, Integer> wordCount = new HashMap<>();

        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        System.out.println("Уникальные слова: " + wordCount.keySet());
        System.out.println(wordCount.entrySet());
    }
}
