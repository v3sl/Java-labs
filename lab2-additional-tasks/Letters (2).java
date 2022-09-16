import java.math.BigDecimal;
strictfp  public class Letters
{
   /**
      Counts the frequencies of letters A-Za-z in a string
      @param str a string
      @return an array of 26 percentages. The i-th count is the percentage of occurrences
      of 'A' + i or 'a' + i among all letters (a number between 0.0 and 1.0).
   */
   strictfp public double[] letterFrequencies(String str)
   {
      str = str.toUpperCase();
     double[] persentagies = new double[26];
     for(char letter : str.toCharArray()) {
        if(letter >= 'A' && letter  <= 'Z') {
           double persent = 1.0/str.length();
          
           persentagies[letter - 65] += (double)Math.round((persent) * 10 ) / 10;
        }        
     }
 
      return persentagies;
   }
}
