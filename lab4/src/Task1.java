import java.util.Scanner;

class Task1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String expression = input.nextLine();
        expression = task1_1(expression);
        System.out.println(expression);
        expression = input.nextLine();
        expression = task1_2(expression);
        System.out.println(expression);
        expression = input.nextLine();
        expression = task1_3(expression);
        System.out.println(expression);
        expression = input.nextLine();
        expression = task1_4(expression);
        System.out.println(expression); 
        input.close();
    }

    private static String task1_1(String expression) {
        return expression.replaceAll("\\b0+(\\.[0-9]+)\\b", "0$1").replaceAll("\\b0+\\b", "0").replaceAll("\\b0+([1-9])+\\b", "$1").replaceAll("\\b0+([1-9]\\.[0-9]+)\\b", "$1");
    }

    private static String task1_2(String expression) {
        return expression.replaceAll("\\b\\w\\b", "").replaceAll("^\\s+|\\s+$", "").replaceAll("\\s+", " ");
    }

    private static String task1_3(String expression) {
        return expression.replaceAll("(\\S)ing\\b", "$1ed");
    }

    private static String task1_4(String expression) {
        return expression.replaceAll("\\b\\d+(\\,|\\.|\\b)", "");
    }
}