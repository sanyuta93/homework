import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneDirectory {
    private Map<String, List<String>> directory;

    public PhoneDirectory() {
        directory = new HashMap<>();
    }

    public void add(String surname, String phoneNumber) {

        if (directory.containsKey(surname)) {
            List<String> phones = directory.get(surname);
            phones.add(phoneNumber);
        } else {

            List<String> phones = new ArrayList<>();
            phones.add(phoneNumber);
            directory.put(surname, phones);
        }
    }

    public List<String> get(String surname) {
        return directory.getOrDefault(surname, new ArrayList<>());
    }

    public static void main(String[] args) {
        PhoneDirectory phoneBook = new PhoneDirectory();

        phoneBook.add("Иванов", "123-456");
        phoneBook.add("Петров", "555-123");
        phoneBook.add("Иванов", "789-012"); // У Иванова теперь два номера
        phoneBook.add("Сидоров", "111-222");

        System.out.println("Иванов: " + phoneBook.get("Иванов"));
        System.out.println("Петров: " + phoneBook.get("Петров"));
        System.out.println("Сидоров: " + phoneBook.get("Сидоров"));
        System.out.println("Несуществующая фамилия: " + phoneBook.get("Кузнецов"));
    }
}
