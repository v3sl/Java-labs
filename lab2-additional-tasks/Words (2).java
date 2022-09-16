import java.util.ArrayList;

public class Words
{
   /**
      Returns the nth short word (length <= 3) in an array.
      @param words an array of strings
      @param n an integer > 0
      @return the nth short word in words, or the empty string if there is
      no such word
   */
   public String nthShortWord(String[] words, int n)
   {
      ArrayList<String> answer = new ArrayList<>();
       for(String word : words) {
          if(word.length() < 4)
            answer.add(word);
       }
      if(answer.size() >= n) 
         return answer.get(n-1);
      return "";
   }
}
