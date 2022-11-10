package Chocolate;

import SweetWithFilling.Fillings;
import SweetWithFilling.SweetWithFilling;

public  class Chocolate extends SweetWithFilling {
    public Chocolate(String brand, double cost, double weight, double percentOfSugar, Fillings filling,
            TypesOfChocolate type) {
        super(brand, cost, weight, percentOfSugar, filling);
        this.type = type;
    }

    private TypesOfChocolate type;

    @Override
    public String toString() {
        return "Chocolate [type=" + type + "]";
    }
}