import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ToyShop {
    private List<Toy> toys;
    private List<Toy> prizeToys;

    public ToyShop() {
        toys = new ArrayList<>();
        prizeToys = new ArrayList<>();
    }

    public void addToy(Toy toy) {
        toys.add(toy);
    }

    public void updateToyWeight(int toyId, double weightPercentage) {
        for (Toy toy : toys) {
            if (toy.getId() == toyId) {
                toy.setWeightPercentage(weightPercentage);
                break;
            }
        }
    }

    public void organizeRaffle() {
        Random random = new Random();
        while (!toys.isEmpty()) {
            double totalWeight = 0;
            for (Toy toy : toys) {
                totalWeight += toy.getWeightPercentage();
            }

            double randomNumber = random.nextDouble() * totalWeight;
            double cumulativeWeight = 0;

            for (int i = 0; i < toys.size(); i++) {
                cumulativeWeight += toys.get(i).getWeightPercentage();
                if (randomNumber <= cumulativeWeight) {
                    Toy prizeToy = toys.get(i);
                    prizeToys.add(prizeToy);
                    toys.remove(i);
                    prizeToy.setQuantity(prizeToy.getQuantity() - 1);
                    break;
                }
            }
        }
    }

    public Toy getPrizeToy() {
        if (!prizeToys.isEmpty()) {
            Toy prizeToy = prizeToys.remove(0);
            System.out.println("Congratulations! You got the prize toy: " + prizeToy.getName());
            return prizeToy;
        } else {
            System.out.println("Sorry, no prize toys left.");
            return null;
        }
    }

    public void writePrizeToysToFile(String filePath, Toy prizeToy) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath, true))) {
            writer.println(prizeToy.toString());
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }

    public void printAvailableToys() {
        System.out.println("Available Toys:");
        for (Toy toy : toys) {
            System.out.println(toy.toString());
        }
    }
}
