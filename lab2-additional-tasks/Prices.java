import java.util.Scanner;
public class Prices
{
   /**
      A method to determine and return the average price
   */
   public static double averagePrice(double[] priceData)
   {  
      double sum = 0;
      for(double element: priceData)
         sum += element;
      return sum / priceData.length;
   }
}
