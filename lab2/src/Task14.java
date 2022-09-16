import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.regex.PatternSyntaxException;
import java.util.stream.IntStream;

public class Task14 {

    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        task14onArray();
        task14onArrayList();
        input.close();
    }

    private static void task14onArray() {
        int[][] matrix = makeMatrixOnArray();
        if (isMagicSquare(matrix))
            System.out.println("Magic square");
        else
            System.out.println("Not magic square");
    }

    private static int[][] makeMatrixOnArray()
            throws IllegalStateException, NoSuchElementException, PatternSyntaxException, NumberFormatException,
            IllegalArgumentException {
        int[][] matrix = new int[0][0];
        int rowIndex = 0;
        while (input.hasNextLine()) {
            String rowString = input.nextLine();
            if (rowString.isEmpty())
                break;
            int[] row = Arrays.stream(rowString.split(" ")).mapToInt(Integer::parseInt).toArray();
            if (rowIndex == 0) {
                matrix = new int[row.length][];
                matrix[rowIndex++] = row;
            } else {
                if (row.length == matrix[0].length)
                    matrix[rowIndex++] = row;
                else {
                    throw new IllegalArgumentException("wrong number of arguments");
                }
            }
        }
        return matrix;
    }

    private static boolean isMagicSquare(int[][] matrix) throws NullPointerException {
        int[] sumsOfRows = Arrays.stream(matrix).mapToInt(row -> Arrays.stream(row).sum()).toArray();
        int[] sumsOfColumns = new int[matrix[0].length];
        for (int i = 0; i < sumsOfColumns.length; ++i) {
            final int column = i;
            int sumOfColumn = Arrays.stream(matrix).mapToInt(row -> row[column]).sum();
            sumsOfColumns[i] = sumOfColumn;
        }
        int sumOfFirstDiagonal = 0;
        int sumOfSecondDiagonal = 0;
        for (int i = 0; i < sumsOfColumns.length; ++i) {
            sumOfFirstDiagonal += matrix[i][i];
            sumOfSecondDiagonal += matrix[i][matrix[0].length - i - 1];
        }
        int[] sumsOfDiagonals = new int[] { sumOfFirstDiagonal, sumOfSecondDiagonal };
        int[] sums = IntStream
                .concat(IntStream.of(sumsOfRows),
                        IntStream.concat(IntStream.of(sumsOfColumns), IntStream.of(sumsOfDiagonals)))
                .toArray();
        return Arrays.asList(sums).stream().distinct().count() <= 1;
    }

    private static void task14onArrayList() {
        ArrayList<ArrayList<Integer>> matrix = makeMatrixOnArrayList();
        if (isMagicSquare(matrix))
            System.out.println("Magic square");
        else
            System.out.println("Not magic square");
    }

    private static ArrayList<ArrayList<Integer>> makeMatrixOnArrayList() throws IllegalStateException,
            NoSuchElementException, PatternSyntaxException, NumberFormatException, IndexOutOfBoundsException {
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<ArrayList<Integer>>();
        while (input.hasNextLine()) {
            String rowString = input.nextLine();
            String[] rowStringArray = rowString.split(" ");
            if (rowString.isEmpty())
                break;
            ArrayList<Integer> row = new ArrayList<>();
            for (int i = 0; i < rowStringArray.length; ++i)
                row.add(Integer.parseInt(rowStringArray[i]));
            if (matrix.isEmpty())
                matrix.add(row);
            else {
                if (row.size() == matrix.get(0).size())
                    matrix.add(row);
                else
                    throw new IllegalArgumentException("wrong number of arguments");
            }
        }
        if (matrix.get(0).size() != matrix.size())
            throw new IllegalArgumentException("different number of columns and rows");
        return matrix;
    }

    private static boolean isMagicSquare(ArrayList<ArrayList<Integer>> matrix) throws IndexOutOfBoundsException {
        ArrayList<Integer> sums = new ArrayList<>();
        for (int i = 0; i < matrix.size(); ++i) {
            int sum = 0;
            for (int element : matrix.get(i))
                sum += element;
            sums.add(sum);
        }
        for (int i = 0; i < matrix.size(); ++i) {
            int sum = 0;
            for (int j = 0; j < matrix.size(); ++j) {
                sum += matrix.get(j).get(i);
            }
            sums.add(sum);
        }
        int sumOfFirstDiagonal = 0;
        int sumOfSecondDiagonal = 0;
        for (int i = 0; i < matrix.size(); ++i) {
            sumOfFirstDiagonal += matrix.get(i).get(i);
            sumOfSecondDiagonal += matrix.get(i).get(matrix.size() - i - 1);
        }
        sums.add(sumOfFirstDiagonal);
        sums.add(sumOfSecondDiagonal);
        return sums.stream().distinct().count() <= 1;
    }
}