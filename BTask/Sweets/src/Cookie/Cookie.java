package Cookie;

import Sweet.Sweet;

public class Cookie extends Sweet {
    public Cookie(String brand, double cost, double weight, double percentOfSugar, TypesOfCookies type) {
        super(brand, cost, weight, percentOfSugar);
        this.type = type;
    }

    private TypesOfCookies type;

    @Override
    public String toString() {
        return "Cookie [type=" + type + "]";
    }
}
