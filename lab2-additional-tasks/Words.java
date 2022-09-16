import java.util.ArrayList;

public class Words
{
   /**
      Returns all short words (length <= 3) in an array of words
      @param words an array of strings
      @return an array list containing the short words in words
   */
   public ArrayList<String> shortWords(String[] words)
   {
       ArrayList<String> answer = new ArrayList<>();
       for(String word : words) {
          if(word.length() < 4)
            answer.add(word);
       }
      return answer;
   }
}
