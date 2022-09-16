public class Swapper
{
   /**
      This method swaps adjacent elements of the given array
      @param values an array
   */
   public void swapAdjacentElements(int[] values)
   {
      for(int i = 0; i < values.length - 1; i += 2) {
         int temp = values[i];
         values[i] = values[i+1];
         values[i+1] = temp;
      }




   }
   
   
   // This method is used to check your work
   public int[] check(int[] values)
   {
      swapAdjacentElements(values);
      return values;
   }
}
