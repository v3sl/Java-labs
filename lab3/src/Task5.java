import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String line = input.nextLine();
        input.close();
        String[] words = line.split("(?=\\.)|(?=,)|(?= )");
        line = "";
        for (int i = 0; i < words.length; ++i) {
            if (i == 0)
                line += words[i].substring(0, 1).toUpperCase() + words[i].substring(1);
            else
                line += words[i].substring(0, 1) + words[i].substring(1, 2).toUpperCase() + words[i].substring(1);
        }
        System.out.println(line);
    }
}
