public class ArrayOps
{
   /**
      This method sums up both rows of a two-dimensional array
      (the only parameter to the method) and returns the greater sum.
      @param theArray, a 2-D array of integers
      @return, the greater row sum
   */
   public static int bigSum(int[][] theArray)
   {
      int greaterSum = 0;
      for(int i = 0; i < theArray.length; ++i) {
         int sum = 0;
         for(int j = 0; j < theArray[0].length; ++j) {
            sum += theArray[i][j];
         }
         if(i == 0)
            greaterSum = sum;
         else {
            if(sum > greaterSum)
               greaterSum = sum;
         }
      }
      return greaterSum;
   }
}
