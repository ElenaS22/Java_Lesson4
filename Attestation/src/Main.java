public class Main {
    public static void main(String[] args) {
        ToyShop toyShop = new ToyShop();

        // Добавляем игрушки в магазин
        toyShop.addToy(new Toy(1, "Teddy Bear", 10, 20.0));
        toyShop.addToy(new Toy(2, "LEGO Set", 5, 15.0));
        toyShop.addToy(new Toy(3, "Doll", 8, 25.0));
        toyShop.addToy(new Toy(4, "Toy Car", 12, 40.0));

        toyShop.printAvailableToys();

        // Обновляем вес игрушки с id 1
        toyShop.updateToyWeight(1, 30.0);

        // Организуем розыгрыш
        toyShop.organizeRaffle();

        // Получаем призовую игрушку и записываем ее в файл
        Toy prizeToy = toyShop.getPrizeToy();
        if (prizeToy != null) {
            toyShop.writePrizeToysToFile("prize_toys.txt", prizeToy);
        }
    }
}
