public class Numbers
{
   /**
      Computes the length of the longest sequence that occurs in the
      start of the left half and the end of the right half of an
      array.
      @param values an array of integer values
      @return the length of the longest end sequence
   */
   public int sameEnds(int[] values)
   {
       int length = 0;
      for(int i = 0; i < values.length / 2; ++i) {
         for(int j = values.length / 2; j < values.length; ++j) {
            if(values[i] == values[j]) {
               ++length;
               while(values[i++] == values[j++] && i < values.length / 2 && j < values.length) {
                  ++length;
               }
            }
         }
      }

      return length;

   }
}
