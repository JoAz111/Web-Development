/**
 * Homework Assignment 14
 *
 * @author Joey Azizoff
 * @version v14.0 10/06/18
 */

 /**
  *Question 1
  * The correct arguements are 2, 3, 4, 5
  */


public class Ex14
{
    /**
     * Finds if a given value is in an array that passes the What function. - Runtime Efficiency O(n) Spacial Efficiency O(1)
     * @param  m A square array sorted in order only in the height and width
     * @param r An Integer
     * @return    true if the integer is in the array false otherwise
     */
    public static boolean findValWhat(int [][]m, int val)
    {
      int i = m.length - 1;
      int j = 0;
      if (val < m[0][0] || val > m[m.length - 1][m.length - 1])
      {
        return false;
      }
      while (j <= m.length-1 && i >=0)
      {
        if (m[j][i] < val)
        {
          j++;
        }
        else
        {
          if (m[j][i] > val)
          {
            i--;
          }
          else
          {
            return true;
          }
        }
      }
      return false;
    }

    /**
     * Finds if a given value is in an array that passes the Test function. - Runtime Efficiency O(n) Spacial Efficiency O(1)
     * @param  m A square array where the values in each row are bigger than the previous rows.
     * @param r An Integer
     * @return    true if the integer is in the array false otherwise
     */
    public static boolean findValTest(int [][]m, int val)
    {
      if (val < m[0][0])
      {
        for (int i=0; i < m.length; i++)
        {
          if (m[i][0] == val)
          {
            return true;
          }
        }
      }
      if (val > m[0][m.length-1])
      {
        for (int i=0; i < m.length; i++)
        {
          if (m[i][m.length - 1] == val)
          {
            return true;
          }
        }
      }
      for (int i = 0; i < m.length-1; i++)
      {
        if (m[0][i] >= val && m[0][i + 1] <= val)
        {
          for (int j = 0; j < m.length; j++)
          {
            if (m[j][i] == val || m[j][i + 1] == val)
            {
              return true;
            }
          }
        }
      }
      return false;
    }

    /**
     * finds the sum of substrings that begin and end with the char and has exactly one char in the middle. - Runtime Efficiency O(n) Spacial Efficiency O(1)
     * @param  s a String
     * @param c a Char
     * @return    The sum of subStrings that begin and end with the Char and has one of the Char in the middle.
     */
    public static int subStrC(String s, char c)
    {
      int i = 0;
      int lastIndex = 0;
      int count = 0;
      int sum = 0;
      while (i < s.length())
      {
        if (s.charAt(i) == c)
        {
          count++;
          if (count == 1)
          {
            i++;
          }
          if (count == 2)
          {
            lastIndex = i;
            i++;
          }
          if (count == 3)
          {
            sum++;
            count = 0;
            i = lastIndex;
          }
        }
        else
        {
          i++;
        }
      }
      return sum;
    }

    /**
     * finds the sum of substrings that begin and end with the char and has no more than k char's in the middle. - Runtime Efficiency O(n) Spacial Efficiency O(1)
     * @param  s a String
     * @param c a Char
     * @param k an Integer
     * @return    The sum of subStrings that begin and end with the Char and has no more than k of the char's in the middle.
     */
    public static int subStrMaxC(String s, char c, int k)
    {
      int count = 0;
      for (int i=0; i < s.length(); i++)
      {
        if (s.charAt(i) == c)
        {
          count++;
        }
      }
      if (count < 2)
      {
        return 0;
      }
      if (count - 2 < k)
      {
        k = count - 2;
      }
      return (k + 1) * count - (((k + 1) * (k + 2)) / 2);
    }

    /**
     * The method recursively calculates how many possible ways spiderman can scale a building of n floors if he can only go up either one or two floors each step.
     * @param  n  an integer
     * @return    the sum of how many possible ways spiderman can climb the building.
     */
    public static int spiderman(int n)
    {
      if (n < 3)
      {
        return n;
      }
      return spiderman(n - 1) + spiderman(n - 2);
    }

    /**
     * The method calculates how many possible ways spiderman can scale a building of n floors (n < 30) using the limitations of the spiderman method if once he reaches a floor above 20 he can take an elevator directly up to the top.
     * @param n  an integer smaller than 30
     * @return    the sum of how many possible ways spiderman can climb the building.
     */
    public static int spidermanPhoneBooth20(int n)
    {
      if (n <= 20)
      {
        return spiderman(n);
      }
      return spiderman(n - 21) * spiderman(19) + spiderman(20);
    }

    /**
     * The method receives a 2d array and finds out how many valid paths are in the array using the limitations of the countPaths function starting from index [0][0]
     * @param mat  a 2d array of positive integers that are smaller than 100
     * @return    the amount of valid paths through the array
     */
    public static int countPaths (int [][] mat)
    {
        return countPaths(mat, 0, 0);
    }

    /**
     * The method receives a 2d array and two index integers one for the column and one for the row and recursively finds how many valid paths are in the array from the index given using the limitations of the countPaths function.
     * @param mat  a 2d array of positive integers that are smaller than 100
     * @param c an integer that is an index of a column
     * @param r an integer that is an index of a row
     * @return    the amount of valid paths through the array
     */
    public static int countPaths(int[][] mat, int c, int r)
    {
      int maxC = mat.length-1;
      int maxR = mat[0].length-1;
      if (c == maxC && r == maxR)
      {
        return 1;
      }
      else if (c > maxC || r > maxR)
      {
        return 0;
      }
      int val = mat[c][r];
      int units = val % 10;
      int tens = val / 10;
      if(val == 0)
      {
        return 0;
      }
       int x = countPaths(mat, c + tens, r + units);
       if(units == tens)
       {
         return x;
       }
       int y = countPaths(mat, c + units, r + tens);
       {
         return x + y;
       }
    }
}
