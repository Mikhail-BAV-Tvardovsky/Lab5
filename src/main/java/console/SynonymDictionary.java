package console;

import java.util.*;

public class SynonymDictionary {
    private final Map<String, LinkedHashSet<String>> dictionary = new TreeMap<>(Comparator.reverseOrder());

    // метод добавления
    public void add(String term, String synonym) {
        for (Map.Entry<String, LinkedHashSet<String>> entry : dictionary.entrySet()) {
            if (!entry.getKey().equals(term) && entry.getValue().contains(synonym)) {
                System.out.println("Предупреждение: Синоним \"" + synonym + "\" уже существует для термина \"" + entry.getKey() + "\".");
                break;
            }
        }

        // Проверка на существование синонима у того же термина
        if (dictionary.containsKey(term) && dictionary.get(term).contains(synonym)) {
            System.out.println("Предупреждение: Синоним \"" + synonym + "\" уже существует для термина \"" + term + "\".");
        }

        if (!dictionary.containsKey(term)) {
            dictionary.put(term, new LinkedHashSet<>());
        }
        dictionary.get(term).add(synonym);    }

    public void printAll() {
        dictionary.forEach((term, synonyms) -> {
            System.out.println(term + ": " + synonyms);
        });
    }

    public static void main(String[] args) {
        SynonymDictionary dictionary = new SynonymDictionary();

        // Добавление терминов и синонимов в словарь
        dictionary.add("быстрый", "скорый");
        dictionary.add("агрессивный", "враждебный");
        dictionary.add("агрессивный", "недружелюбный");
        dictionary.add("быстрый", "стремительный");
        dictionary.add("напористый", "стремительный");
        dictionary.add("медленный", "неторопливый");
        dictionary.add("медленный", "медлительный");
        dictionary.add("умный", "интеллектуальный");
        dictionary.add("умный", "образованный");
        dictionary.add("счастливый", "радостный");
        dictionary.add("счастливый", "веселый");
        dictionary.add("красивый", "прекрасный");
        dictionary.add("красивый", "симпатичный");
        dictionary.add("грустный", "печальный");
        dictionary.add("грустный", "меланхоличный");

        // Проверка добавления существующего синонима для другого термина
        dictionary.add("грустный", "образованный"); // Ожидается предупреждение

        System.out.println("\nВесь словарь:");
        dictionary.printAll();
    }
}
