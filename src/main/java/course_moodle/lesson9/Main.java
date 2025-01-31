package course_moodle.lesson9;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Задача 1: Подсчёт чётных чисел в случайно-сгенерированном наборе
        int[] randomNumbers = generateRandomNumbers(10); // Генерация 10 случайных чисел
        System.out.println("Сгенерированные числа: " + Arrays.toString(randomNumbers));
        int evenCount = countEvenNumbers(randomNumbers);
        System.out.println("Количество чётных чисел: " + evenCount);

        // Задача 2: Работа с коллекцией строк
        List<String> stringList = Arrays.asList("Highload", "High", "Load", "Highload");

        // 2.1: Подсчёт количества вхождений "High"
        int highCount = Collections.frequency(stringList, "High");
        System.out.println("Количество вхождений 'High': " + highCount);

        // 2.2: Получение первого элемента коллекции
        String firstElement = getFirstElement(stringList);
        System.out.println("Первый элемент коллекции: " + firstElement);

        // 2.3: Получение последнего элемента коллекции
        String lastElement = getLastElement(stringList);
        System.out.println("Последний элемент коллекции: " + lastElement);

        // Задача 3: Сортировка коллекции строк и добавление в массив
        List<String> stringCollection = Arrays.asList("f10", "f15", "f2", "f4", "f4");
        String[] sortedArray = sortAndConvertToArray(stringCollection);
        System.out.println("Отсортированный массив: " + Arrays.toString(sortedArray));

        // Задача 5: Ввод логинов и вывод тех, что начинаются на "f"
        List<String> logins = collectLogins();
        System.out.println("Логины, начинающиеся на 'f': " + filterLoginsStartingWithF(logins));
    }

    // Метод для генерации случайных чисел
    public static int[] generateRandomNumbers(int size) {
        Random random = new Random();
        int[] numbers = new int[size];
        for (int i = 0; i < size; i++) {
            numbers[i] = random.nextInt(100); // Генерация чисел от 0 до 99
        }
        return numbers;
    }

    // Метод для подсчёта чётных чисел
    public static int countEvenNumbers(int[] numbers) {
        int count = 0;
        for (int number : numbers) {
            if (number % 2 == 0) {
                count++;
            }
        }
        return count;
    }

    // Метод для получения первого элемента коллекции
    public static String getFirstElement(List<String> list) {
        if (list.isEmpty()) {
            return "0";
        }
        return list.get(0);
    }

    // Метод для получения последнего элемента коллекции
    public static String getLastElement(List<String> list) {
        if (list.isEmpty()) {
            return "0";
        }
        return list.get(list.size() - 1);
    }

    // Метод для сортировки коллекции строк и преобразования в массив
    public static String[] sortAndConvertToArray(List<String> list) {
        List<String> sortedList = new ArrayList<>(list);
        Collections.sort(sortedList);
        return sortedList.toArray(new String[0]);
    }

    // Метод для сбора логинов от пользователя
    public static List<String> collectLogins() {
        Scanner scanner = new Scanner(System.in);
        List<String> logins = new ArrayList<>();
        System.out.println("Вводите логины (для завершения введите пустую строку):");

        while (true) {
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                break; // Прекращаем ввод, если введена пустая строка
            }
            logins.add(input);
        }

        return logins;
    }

    // Метод для фильтрации логинов, начинающихся на "f"
    public static List<String> filterLoginsStartingWithF(List<String> logins) {
        List<String> filteredLogins = new ArrayList<>();
        for (String login : logins) {
            if (login.startsWith("f")) {
                filteredLogins.add(login);
            }
        }
        return filteredLogins;
    }
}

