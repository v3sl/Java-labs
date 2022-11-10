package Sweet;
public class Sweet {

    public Sweet(String brand, double cost, double weight, double percentOfSugar) {
        this.brand = brand;
        this.cost = cost;
        this.weight = weight;
        this.percentOfSugar = percentOfSugar;
    }

    public String getBrand() {
        return brand;
    }

    public double getCost() {
        return cost;
    }

    public double getWeight() {
        return weight;
    }

    public double getPercentOfSugar() {
        return percentOfSugar;
    }

    private String brand;
    private double cost;
    private double weight;
    private double percentOfSugar;
    @Override
    public String toString() {
        return "Sweet [brand=" + brand + ", cost=" + cost + ", weight=" + weight + ", percentOfSugar=" + percentOfSugar
                + "]";
    }
}