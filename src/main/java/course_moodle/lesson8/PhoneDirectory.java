package course_moodle.lesson8;
import java.util.*;

public class PhoneDirectory {
    private Map<String, List<String>> directory;

    public PhoneDirectory() {
        directory = new HashMap<>();
    }

    public void add(String lastName, String phoneNumber) {
        if (directory.containsKey(lastName)) {
            List<String> phoneNumbers = directory.get(lastName);
            phoneNumbers.add(phoneNumber);
        } else {
            List<String> phoneNumbers = new ArrayList<>();
            phoneNumbers.add(phoneNumber);
            directory.put(lastName, phoneNumbers);
        }
    }

    public List<String> get(String lastName) {
        return directory.getOrDefault(lastName, new ArrayList<>());
    }

    public static void main(String[] args) {
        PhoneDirectory phoneDirectory = new PhoneDirectory();

        phoneDirectory.add("Smith", "1234567890");
        phoneDirectory.add("Johnson", "9876543210");
        phoneDirectory.add("Smith", "5555555555");

        System.out.println("Телефоны для фамилии Smith: " + phoneDirectory.get("Smith"));
        System.out.println("Телефоны для фамилии Johnson: " + phoneDirectory.get("Johnson"));
        System.out.println("Телефоны для фамилии Doe: " + phoneDirectory.get("Doe"));
    }
}