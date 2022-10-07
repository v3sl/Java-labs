import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {

    }
    
    private static int[][] task1_3(File file)
            throws NoSuchElementException, FileNotFoundException, IllegalArgumentException, InputMismatchException {
        try (Scanner input = new Scanner(file)) {
            int r = input.nextInt();
            if (r <= 0)
                throw new IllegalArgumentException("r < 0");
            int c = input.nextInt();
            if (c <= 0)
                throw new IllegalArgumentException("c < 0");
            int[][] matrix = new int[r][c];
            for (int i = 0; i < r; ++i) {
                for (int j = 0; j < c; ++j)
                    matrix[i][j] = input.nextInt();
            }
            if (input.hasNext())
                throw new IllegalArgumentException("");
            return matrix;
        }
    }
}
