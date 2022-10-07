import java.util.Arrays;
import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String line = input.nextLine();
        input.close();
        line = String.join(" ", Arrays.stream(line.split(" ")).filter(word -> word.length() != 1).toArray(String[]:: new)).replaceAll("\\s+", " ").trim();
        System.out.println(line);
    }
}