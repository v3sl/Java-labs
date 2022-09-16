import java.util.Arrays;

public class Letters
{
   /**
      Counts the frequencies of letters A-Za-z in a string
      @param str a string
      @return an array of 26 counts. The i-th count is the number of occurrences
      of 'A' + i or 'a' + i.
   */
   public int[] letterFrequencies(String str)
   {
     int[] answer = new int[26];
     char[] newStr = str.toUpperCase().toCharArray();
     for(int i = 0; i < newStr.length; ++i) {
        if(newStr[i] >= 'A' && newStr[i] <= 'Z'){
           int number = newStr[i] -65;
            ++answer[number];
        }
     }
      return answer;
   }
}
