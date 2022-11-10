package Gift;
import java.util.ArrayList;
import java.util.Comparator;
import Sweet.Sweet;

public class Gift {
    public Gift(ArrayList<? extends Sweet> sweets) {
        this.sweets = sweets;
        weight = findWeight();
    }

    private double findWeight(){
        double weightOfGift = 0;
        for(Sweet sweet : sweets) {
            weightOfGift += sweet.getWeight();
        }
        return weightOfGift;
    }

    public void sort(Comparator<? super Sweet> comparator) {
        sweets = new ArrayList<Sweet>(sweets.stream().sorted(comparator).toList());
    }

    public ArrayList<Sweet> findByPercentOfSugar(double from, double to) {
        return new ArrayList<Sweet>(sweets.stream().filter(sweet -> sweet.getPercentOfSugar() >= from && sweet.getPercentOfSugar() <= to).toList());        
    }

    public double getWeight() {
        return weight;
    }

    private double weight;
    private  ArrayList<? extends Sweet> sweets;
    @Override
    public String toString() {
        return "Gift [weight=" + weight + ", sweets=" + sweets + "]";
    }
}
