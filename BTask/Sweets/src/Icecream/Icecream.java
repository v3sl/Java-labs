package Icecream;

import Sweet.Sweet;

public class Icecream extends Sweet {
    public Icecream(String brand, double cost, double weight, double percentOfSugar, TypesOfIcecream type) {
        super(brand, cost, weight, percentOfSugar);
        this.type = type;
    }

    private TypesOfIcecream type;

    @Override
    public String toString() {
        return "Icecream [type=" + type + "]";
    }
}