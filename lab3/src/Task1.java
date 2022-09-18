import java.util.Arrays;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String line = input.nextLine();
        input.close();
        String[] numbers = line.trim().split("\\s+");
        double[] doubleValues = Arrays.stream(numbers)
                .mapToDouble(Double::parseDouble)
                .toArray();
        line = "";
        for (double value : doubleValues)
            line += String.valueOf(value) + " ";
        System.out.println(line);
    }
}