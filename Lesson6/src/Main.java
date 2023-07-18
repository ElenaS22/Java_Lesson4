import java.util.*;

public class Main {
    public static void main(String[] args) {
        Set<Laptop> laptops = new HashSet<>();

        // Добавляем ноутбуки в множество
        laptops.add(new Laptop("Laptop 1", 8, 256, "Windows 10", "Black"));
        laptops.add(new Laptop("Laptop 2", 16, 512, "MacOS", "Silver"));
        laptops.add(new Laptop("Laptop 3", 8, 512, "Windows 10", "White"));
        laptops.add(new Laptop("Laptop 4", 16, 1024, "Windows 11", "Grey"));

        // Запускаем фильтрацию и выводим результаты
        Map<Integer, Object> filters = getFiltersFromUser();
        Set<Laptop> filteredLaptops = filterLaptops(laptops, filters);
        printLaptops(filteredLaptops);
    }
    // Метод для получения критериев фильтрации от пользователя
    private static Map<Integer, Object> getFiltersFromUser() {
        Scanner scanner = new Scanner(System.in);
        Map<Integer, Object> filters = new HashMap<>();

        System.out.println("Введите номер критерия для фильтрации:");
        System.out.println("1 - ОЗУ");
        System.out.println("2 - Объем ЖД");
        System.out.println("3 - Операционная система");
        System.out.println("4 - Цвет");
        System.out.println("Введите -1, чтобы завершить ввод критериев.");

        int criterion;
        while ((criterion = scanner.nextInt()) != -1) {
            switch (criterion) {
                case 1:
                    System.out.println("Введите минимальный объем ОЗУ:");
                    int minRam = scanner.nextInt();
                    filters.put(criterion, minRam);
                    break;
                case 2:
                    System.out.println("Введите минимальный объем ЖД:");
                    int minStorage = scanner.nextInt();
                    filters.put(criterion, minStorage);
                    break;
                case 3:
                    System.out.println("Введите требуемую операционную систему:");
                    String os = scanner.next();
                    filters.put(criterion, os);
                    break;
                case 4:
                    System.out.println("Введите требуемый цвет:");
                    String color = scanner.next();
                    filters.put(criterion, color);
                    break;
                default:
                    System.out.println("Неверный номер критерия.");
                    break;
            }

            System.out.println("Введите следующий номер критерия или -1 для завершения:");
        }

        return filters;
    }

    // Метод для фильтрации ноутбуков на основе заданных критериев
    private static Set<Laptop> filterLaptops(Set<Laptop> laptops, Map<Integer, Object> filters) {
        Set<Laptop> filteredLaptops = new HashSet<>(laptops);

        for (Map.Entry<Integer, Object> entry : filters.entrySet()) {
            int criterion = entry.getKey();
            Object value = entry.getValue();

            switch (criterion) {
                case 1:
                    int minRam = (int) value;
                    filteredLaptops.removeIf(laptop -> laptop.getRam() < minRam);
                    break;
                case 2:
                    int minStorage = (int) value;
                    filteredLaptops.removeIf(laptop -> laptop.getStorage() < minStorage);
                    break;
                case 3:
                    String os = (String) value;
                    filteredLaptops.removeIf(laptop -> !laptop.getOs().equalsIgnoreCase(os));
                    break;
                case 4:
                    String color = (String) value;
                    filteredLaptops.removeIf(laptop -> !laptop.getColor().equalsIgnoreCase(color));
                    break;
                default:
                    break;
            }
        }

        return filteredLaptops;
    }

    // Метод для вывода информации о ноутбуках
    private static void printLaptops(Set<Laptop> laptops) {
        System.out.println("Найденные ноутбуки:");
        for (Laptop laptop : laptops) {
            System.out.println("Модель: " + laptop.getModel());
            System.out.println("ОЗУ: " + laptop.getRam() + " GB");
            System.out.println("Объем ЖД: " + laptop.getStorage() + " GB");
            System.out.println("Операционная система: " + laptop.getOs());
            System.out.println("Цвет: " + laptop.getColor());
            System.out.println();
        }
    }
}

