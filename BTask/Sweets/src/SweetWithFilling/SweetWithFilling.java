package SweetWithFilling;

import Sweet.Sweet;

public class SweetWithFilling extends Sweet {
    public SweetWithFilling(String brand, double cost, double weight, double percentOfSugar, Fillings filling) {
        super(brand, cost, weight, percentOfSugar);
        this.filling = filling;
    }

    private Fillings filling;

    @Override
    public String toString() {
        return "SweetWithFilling [filling=" + filling + "]";
    }
}