package course_moodle.lesson8;
import java.util.*;

public class UniqueWordsCounter {
    public static void main(String[] args) {
        String[] wordsArray = {"apple", "banana", "apple", "orange", "banana", "grape", "apple", "kiwi", "orange", "kiwi"};

        // Создаем список для хранения слов и их частоты
        Map<String, Integer> wordFrequencyMap = new HashMap<>();

        // Подсчитываем частоту каждого слова
        for (String word : wordsArray) {
            wordFrequencyMap.put(word, wordFrequencyMap.getOrDefault(word, 0) + 1);
        }

        // Выводим уникальные слова и количество их повторений
        System.out.println("Уникальные слова и количество повторений:");
        for (Map.Entry<String, Integer> entry : wordFrequencyMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        // Выводим список уникальных слов
        System.out.println("\nСписок уникальных слов:");
        Set<String> uniqueWords = wordFrequencyMap.keySet();
        for (String word : uniqueWords) {
            System.out.println(word);
        }
    }
}
