import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class Task3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String line = input.nextLine();
        input.close();
        String[] words = line.split(" ");
        for(int i = 0; i < words.length; ++i) {
            if(words[i].length() == 1)
                words[i] = " ";
        }
        line = String.join(" ", words).trim().replaceAll("\\s+", " ");
        System.out.println(line);
    }
}