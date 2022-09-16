import java.util.*;
import java.util.stream.Collectors;

public class ArrayOps
{
   /**
       This method goes through the array of integers identified by
       the only parameter, creating a new ArrayList from the array,
       eliminating duplicates from the original array.
       @param theArray, an array of integer
       @return uniqueIntAL, the new ArrayList

   */
   public static ArrayList<Integer> copyArray(int[] anArray)
   {
      anArray = Arrays.stream(anArray).distinct().toArray();
      ArrayList<Integer> answer = (ArrayList<Integer>)Arrays.stream(anArray).boxed().collect(Collectors.toList());
      return answer;
   }
}
