import java.util.stream.IntStream;

public class Swapper
{
   /**
      This method swaps the first and second half of the given array.
      @param values an array
   */
   public void swapFirstAndSecondHalf(int[] arr)
   { 
      int mod = arr.length % 2;
        for (int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length / 2 + i + mod];
            arr[arr.length / 2 + i + mod] = temp;
        }
   }

   
   // This method is used to check your work
   public int[] check(int[] values)
   {
      swapFirstAndSecondHalf(values);
      return values;
   }
}
