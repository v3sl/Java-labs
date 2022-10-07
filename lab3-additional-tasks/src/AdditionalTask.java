import java.io.IOException;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.regex.PatternSyntaxException;

public class AdditionalTask {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // System.out.println(Arrays
        //         .stream(input.nextLine().replaceAll("x",
        //                 Integer.toString(input.nextInt())).replaceAll("\\s+",
        //                         "")
        //                 .replaceAll("--", "+")
        //                 .split("(?=-)|\\+"))
        //         .filter(string -> string.length() != 0)
        //         .mapToInt(Integer::parseInt).sum());
        System.out.println(calculate(input.nextLine(), input.nextInt()));
        input.close();
    }

    /**
     * @throws PatternSyntaxException
     * @throws NoSuchElementException
     * @throws IndexOutOfBoundsException
     */
    public static int calculate(String line, int x)
            throws PatternSyntaxException, NoSuchElementException, IndexOutOfBoundsException {
        StringTokenizer tokenizer = new StringTokenizer(
                line.replaceAll("\\s+", "").replaceAll("x", Integer.toString(x)), "-|\\+", true);
        int result = "-".equals(tokenizer.nextToken()) ? Integer.parseInt(tokenizer.nextToken()) * (-1)
                : Integer.parseInt(tokenizer.nextToken());
        while (tokenizer.hasMoreTokens()) {
            switch (tokenizer.nextToken()) {
                case "+": {
                    String currentToken = tokenizer.nextToken();
                    if ("-".equals(currentToken))
                        result -= Integer.parseInt(tokenizer.nextToken());
                    else
                        result += Integer.parseInt(currentToken);
                    break;
                }
                case "-":
                    String currentToken = tokenizer.nextToken();
                    if ("-".equals(currentToken))
                        result += Integer.parseInt(tokenizer.nextToken());
                    else
                        result -= Integer.parseInt(currentToken);
                    break;
                default:
                    break;
            }
        }
        return result;
    }
}