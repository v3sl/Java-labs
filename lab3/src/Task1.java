import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String line = input.nextLine();
        input.close();
        String[] parsedString = line.trim().split("(?=\\.)|(?=[A-Za-z]+)|(?=\\s)");
        line = "";
        for (int i = 0; i < parsedString.length; ++i) {
            if (parsedString[i].charAt(0) != '.' && parsedString[i].length() > 1
                    && Character.isDigit(parsedString[i].charAt(1)))
                line += "" + (!Character.isDigit(parsedString[i].charAt(0)) ? parsedString[i].charAt(0) : "")
                        + Integer.parseInt(parsedString[i].substring(1));
            else
                line += parsedString[i];
        }
        System.out.println(line);
    }
}