public class Numbers
{
   /**
      Computes the number of even and odd values in a given array
      @param values an array of integer values
      @return an array of length 2 whose 0 entry contains the count
      of even elements and whose 1 entry contains the count of odd
      values
   */
   public int[] evenOdds(int[] values)
   {
      int even = 0;
      int odd = 0;
      for(int value: values) {
         if(value % 2  == 0)
            ++even;
         else 
            ++odd;
      } 
      return new int[]{even, odd};
   }
}
