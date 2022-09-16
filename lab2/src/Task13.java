import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Task13 {
    public static void main(String[] args) {
        task13OnArray();
        task13OnArrayList();
    }
    private static void task13OnArray() {   
        int[] numbers = new int[49];
        for (int i = 0; i < numbers.length; ++i)
            numbers[i] = i + 1;
        int[] ticket = createTicket(numbers);
        System.out.println(Arrays.toString(ticket));
    }

    private static int[] createTicket(int[] array) {
        int[] resultNumbers = new int[6];
        for (int i = 0; i < 6; ++i) {
            int index = createIndex(array.length);
            resultNumbers[i] = array[index];
            array = deleteByIndex(array, index);
        }
        Arrays.sort(resultNumbers);
        return resultNumbers;
    }

    private static int createIndex(int upperbound) throws IllegalArgumentException {
        Random generator = new Random();
        return generator.nextInt(upperbound);
    }

    private static int[] deleteByIndex(int[] array, int index)
            throws IndexOutOfBoundsException, ArrayStoreException, NullPointerException {
        int[] newNumbers = new int[array.length - 1];
        System.arraycopy(array, 0, newNumbers, 0, index);
        System.arraycopy(array, index + 1, newNumbers, index, array.length - index - 1);
        return newNumbers;
    }

    private static void task13OnArrayList() {
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 49; ++i)
            numbers.add(i + 1);
        ArrayList<Integer> ticket = createTicket(numbers);
        System.out.println(ticket);
    }

    private static ArrayList<Integer> createTicket(ArrayList<Integer> numbers) throws IndexOutOfBoundsException,
            ClassCastException, UnsupportedOperationException, IllegalArgumentException {
        ArrayList<Integer> resultNumbers = new ArrayList<>();
        for (int i = 0; i < 6; ++i) {
            int index = createIndex(numbers.size());
            resultNumbers.add(numbers.remove(index));
        }
        Collections.sort(resultNumbers);
        return resultNumbers;
    }
    
}