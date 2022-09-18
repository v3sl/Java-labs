import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String line = input.nextLine();
        input.close();
        line = getCapitalizeWordsString(line);
        System.out.println(line);
    }

    private static String getCapitalizeWordsString(String string) {
        char[] charString = string.toCharArray();
        for (int i = 0; i < charString.length; ++i) {
            if (Character.isLetter(charString[i]) && i == 0)
                charString[i] = Character.toUpperCase(charString[i]);
            if ((charString[i] == ' ' || charString[i] == '.' || charString[i] == ',')
                    && Character.isLetter(charString[i + 1]))
                charString[i + 1] = Character.toUpperCase(charString[i + 1]);
        }
        return String.valueOf(charString);
    }
}
