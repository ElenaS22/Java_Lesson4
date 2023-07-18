public class Toy {
    private int id;
    private String name;
    private int quantity;
    private double weightPercentage;

    public Toy(int id, String name, int quantity, double weightPercentage) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.weightPercentage = weightPercentage;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getWeightPercentage() {
        return weightPercentage;
    }

    public void setWeightPercentage(double weightPercentage) {
        this.weightPercentage = weightPercentage;
    }

    @Override
    public String toString() {
        return "Toy{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", weightPercentage=" + weightPercentage +
                '}';
    }
}
