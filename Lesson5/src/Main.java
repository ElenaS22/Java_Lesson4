import java.util.*;

public class Main {

        public static void main(String[] args) {
            // Создаем телефонную книгу (HashMap)
            HashMap<String, List<String>> phoneBook = new HashMap<>();

            // Добавляем записи в телефонную книгу
            addContact(phoneBook, "Иван Иванов", "1234567890");
            addContact(phoneBook, "Иван Иванов", "9876543210");
            addContact(phoneBook, "Петр Петров", "5555555555");
            addContact(phoneBook, "Петр Петров", "9999999999");
            addContact(phoneBook, "Марфа Васильева", "01111111111");

            // Сортируем записи по убыванию числа телефонов
            List<Map.Entry<String, List<String>>> sortedEntries = new ArrayList<>(phoneBook.entrySet());
            sortedEntries.sort((a, b) -> b.getValue().size() - a.getValue().size());

            // Выводим отсортированные записи
            for (Map.Entry<String, List<String>> entry : sortedEntries) {
                String name = entry.getKey();
                List<String> phoneNumbers = entry.getValue();
                System.out.println(name + ": " + phoneNumbers.size() + " номер телефона");

                for (String phoneNumber : phoneNumbers) {
                    System.out.println(phoneNumber);
                }

                System.out.println();
            }
        }

        // Метод для добавления записи в телефонную книгу
        private static void addContact(Map<String, List<String>> phoneBook, String name, String phoneNumber) {
            // Если имя уже есть в книге, добавляем номер телефона в список для данного имени
            if (phoneBook.containsKey(name)) {
                List<String> phoneNumbers = phoneBook.get(name);
                phoneNumbers.add(phoneNumber);
            } else {
                // Если имя не найдено, создаем новый список для данного имени и добавляем номер телефона
                List<String> phoneNumbers = new ArrayList<>();
                phoneNumbers.add(phoneNumber);
                phoneBook.put(name, phoneNumbers);
            }
        }
    }
