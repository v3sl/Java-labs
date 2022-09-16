public class Grades
{
   /**
      This method examines the two-dimensional array of integers
      identified by the first parameter, whose length (number of rows,
      also the number of students) is the second parameter, while the
      three columns in the array represent the scores for three
      different tests.
      The test scores for each student (one row of three grades) are
      combined to find the average score for each student.  The integer
      returned is the number of students with a test average less than 70. 
      @param numStudents, the number of students who took the three tests
      @param theArray, a 2-D array of integer scores
      @return, the number of test averages below a score of 70
   */
   public static int testAverage(double[][] theArray, int numStudents)
   {
      int NUM_TESTS = 3;
      int count = 0;
      for(int i = 0; i < theArray.length; ++i) {
         double avg = 0;
         for(double element: theArray[i])
            avg += element;
         avg /= theArray[i].length;
         if(avg < 70.0)
            ++count;
      }
      return count;
   }
}
