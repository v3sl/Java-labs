public class Numbers 
{
   /**
      Produces a string containing the numbers in an array,
      separated by commas, such as "1,4,9"
      @param values an array of integer values
      @return a string containing the array elements, separated by
      commas.
    */
   public String separateWithCommas(int[] values)
   {
      String answer = "";
      for(int i = 0; i < values.length; ++i) {
         answer += values[i];
         if(values.length != 1 && i != values.length - 1)
            answer += ",";
      }
      return answer;
   }
}
