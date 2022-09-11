import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws Exception {
        task1(16);
        task2(360);
        task3(2, 10, -1);
        task4();
        task5();
        task6(1000);
        task7((short) 10, (short) 20);
    }

    public static void task1(int number) {
        System.out.println(Integer.toString(number, 2));
        System.out.println(Integer.toString(number, 8));
        System.out.println(Integer.toString(number, 16));
        Double reverseNumber = (double) 1 / number;
        System.out.println(Double.toHexString(reverseNumber));
    }

    public static void task2(int angle) {
        System.out.println(Math.floorMod(angle, 360));
        while (angle <= 0)
            angle += 360;
        System.out.println(angle % 360);
    }

    public static void task3(int first, int second, int third) {
        if (first > second) {
            if (first > third) {
                System.out.println(first);
            } else
                System.out.println(second);
        } else if (second > third) {
            System.out.println(second);
        } else
            System.out.println(third);
        System.out.println(Math.max(first, Math.max(second, third)));
    }

    public static void task4() {
        System.out.println(Double.MAX_VALUE);
        System.out.println(Math.nextUp((double) 0));
    }

    public static void task5() {
        int test = (int) Double.MAX_VALUE;
        System.out.println(test);
    }

    public static void task6(int number) {
        BigInteger answer = BigInteger.valueOf(1);
        while (number > 0) {
            answer = answer.multiply(BigInteger.valueOf(number));
            number--;
        }
        System.out.println(answer.toString());
    }

    public static void task7(short first, short second) {
        System.out.println((short) (first + second));
        System.out.println((short) (first - second));
        System.out.println((short) (first * second));
        System.out.println((short) (first / second));
        System.out.println((short) (first % second));
    }
}
