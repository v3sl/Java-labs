public class Words
{
   /**
      Removes all short words (length <= 3) from an array. The 
      order of the remaining element is left unchanged. The unused
      end of the array is filled with empty strings.
      @param words the array from which the short words are to be removed
   */
   public static void removeShortWords(String[] words)
   {
      String[] newWords = new String[words.length];
      int end = words.length - 1;
      int begin = 0;
      for(int i = 0; i < words.length; ++i) {
         if(words[i].length() < 4)
            newWords[end--] = "";
         else {
            newWords[begin++] = words[i];
         }
      }
      for(int i = 0; i < words.length; ++i)
         words[i] = newWords[i];
   }
}
