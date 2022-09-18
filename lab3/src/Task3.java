import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String line = input.nextLine();
        input.close();
        line = line.trim().replaceAll("\\s+", " ");
        System.out.println(line);
    }
}