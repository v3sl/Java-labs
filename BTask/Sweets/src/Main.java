import java.util.ArrayList;
import java.util.Comparator;

import Chocolate.Chocolate;
import Chocolate.TypesOfChocolate;
import Cookie.Cookie;
import Cookie.TypesOfCookies;
import Gift.Gift;
import Sweet.Sweet;
import SweetWithFilling.Fillings;

public class Main {
    public static void main(String[] args) {
        Chocolate c1 = new Chocolate("sad", 100, 200, 20, Fillings.CARAMEL,TypesOfChocolate.DESSERT);
        
        Cookie c2 = new Cookie("sad", 120, 150.2, 20, TypesOfCookies.CRACKER);
        
        Chocolate c3 = new Chocolate("sad", 100, 150.1, 20, Fillings.CARAMEL,TypesOfChocolate.DESSERT);
        ArrayList<Sweet> ar = new ArrayList<>();
        ar.add(c1);
        ar.add(c2);
        ar.add(c3);

        Gift gift = new Gift(ar);
        System.out.println(gift);
        
        gift.sort(new Comparator<Sweet>() {

            @Override
            public int compare(Sweet o1, Sweet o2) {
                return (int)(o1.getWeight()-o2.getWeight());
            }
            
        });
        System.out.println(gift);

    }
}
