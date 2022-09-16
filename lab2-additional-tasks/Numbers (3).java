public class Numbers
{
   public int lengthOfLongestRun(int[] values)
   {
      int maxCount = 0;
      for(int i = 0; i < values.length; ++i) {
         int currentCount = 1;
         for(int j = i + 1; j < values.length; ++j) {
            if(values[i] == values[j])
               ++currentCount;
            else {
               i = j - 1;
               break;
            }
         }
         if(currentCount > maxCount)
            maxCount = currentCount;
         
      }
      return maxCount;
   }
}
