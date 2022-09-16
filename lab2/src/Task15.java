import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Task15 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        input.close();
        task15OnArray(n);
        task15OnArrayList(n);
    }

    private static void task15OnArray(int n) {
        int[][] triangle = createTriangleOnArray(n);
        Arrays.stream(triangle).forEach(row -> System.out.println(Arrays.toString(row)));
    }

    private static int[][] createTriangleOnArray(int n) {
        int[][] triangle = new int[n][];
        int[] previousRow = new int[0];
        int[] currentRow = new int[0];
        for (int i = 0; i < n; ++i) {
            if (i == 0)
                currentRow = new int[] { 1 };
            else {
                int index = 1;
                currentRow = new int[previousRow.length + 1];
                for (int j = 0; j < currentRow.length; ++j) {
                    if (j == 0 || j == currentRow.length - 1)
                        currentRow[j] = 1;
                    else
                        currentRow[j] = previousRow[index - 1] + previousRow[index++];
                }
            }
            triangle[i] = currentRow;
            previousRow = currentRow;
        }
        return triangle;
    }

    private static void task15OnArrayList(int n) {
        ArrayList<ArrayList<Integer>> triangle = createTriangleOnArrayList(n);
        System.out.println(triangle);
    }

    private static ArrayList<ArrayList<Integer>> createTriangleOnArrayList(int n) {
        ArrayList<ArrayList<Integer>> triangle = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> previousRow = new ArrayList<>();
        ArrayList<Integer> currentRow = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            if (i == 0)
                currentRow.add(1);
            else {
                int index = 1;
                currentRow = new ArrayList<>();
                for (int j = 0; j < previousRow.size() + 1; ++j) {
                    if (j == 0 || j == previousRow.size())
                        currentRow.add(1);
                    else
                        currentRow.add(previousRow.get(index - 1) + previousRow.get(index++));
                }
            }
            triangle.add(currentRow);
            previousRow = new ArrayList<>();
            previousRow.addAll(0, currentRow);
        }
        return triangle;
    }
}