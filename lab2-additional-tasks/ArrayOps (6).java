import java.util.*;
import java.util.stream.Collectors;

public class ArrayOps
{
   /**
      This method goes through the array of integers identified by
      the only parameter, creating a new ArrayList from the array,
      but in reverse order.
      @param theArray, an array of integers
      @return reversedArr, the new ArrayList of Integers

   */
   public static ArrayList<Integer> copyReverse(int[] anArray)
   {
      for(int i = 0; i < anArray.length/2; ++i) {
            int temp = anArray[i];
            anArray[i] = anArray[anArray.length - 1 - i];
            anArray[anArray.length - 1 - i] = temp;
         }
         ArrayList<Integer> answer = (ArrayList<Integer>)Arrays.stream(anArray).boxed().collect(Collectors.toList());
         return answer;
   }
}
