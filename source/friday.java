/*
ID: mchensd
LANG: JAVA
PROG: friday
 */
/**
 *
 * @author Michael
 */

import java.io.*;
import java.util.stream.IntStream;
public class friday {
    /**
     * @param args the command line arguments
     */
    
    public static int getThirteenthOf(int firstDay) {
        // Return the thirteenth of a month, all we need to know is the first day
        // 0 - Sat, 1 - Sun ... Fri - 6
        
        return (firstDay + 5) % 7;
    }
    
    public static int firstOfNext(int currMonth, int firstDay, boolean isLeap)
    { // returns the first day of the month after currMonth given the currentMonth and currentDay
        int[] thirtyOneDays = {1, 3, 5, 7, 8, 10, 12};
        int[] thirtyDays = {4,6,9,11};
        if (IntStream.of(thirtyOneDays).anyMatch(x -> x == currMonth)) { // 31 days
            return (firstDay + 3) % 7;        
        } 
        
        else if (IntStream.of(thirtyDays).anyMatch(x -> x == currMonth)) { // 30 days
            return (firstDay + 2) % 7;
        }
        
        else if (currMonth == 2 && isLeap) return (firstDay + 1) % 7;
        
        else if (currMonth == 2 && !isLeap) return (firstDay);
        
        else throw new IllegalArgumentException();
        
    }
    public static void main(String[] args) throws IOException {
        /**
         * function thirteenthOf(month, firstDay) -> day the thirteenth is on
         * function firstOfNext(currMonth, currDay) -> day of the first of the month after currMonth
         * 
         * have 12 * n months to check
         * for each month:
         *      get the thirteenthOf that month
         *      move to next month
         */
        BufferedReader f;
        PrintWriter out;
        
        f = new BufferedReader(new FileReader("friday.in"));
        out = new PrintWriter(new BufferedWriter(new FileWriter("friday.out")));
        
        int n = Integer.parseInt(f.readLine());
        int year = 1900;
        int firstDay = 2;
        
        boolean isLeapYear = false;
        if (year % 400 == 0) isLeapYear = true;  // century leap year
        else if (year % 4 == 0 && !(year % 100 == 0)) isLeapYear = true;
        
        int[] daysOfWeek = {0,0,0,0,0,0,0};
        for (int i=0; i < n; i++) {
            for (int month=1; month < 13; month++) {
                int thirteenth = getThirteenthOf(firstDay);
                daysOfWeek[thirteenth]++;
                firstDay = firstOfNext(month, firstDay, isLeapYear);
            }
            year++;
            isLeapYear = false;
            if (year % 400 == 0) isLeapYear = true;  // century leap year
            else if (year % 4 == 0 && !(year % 100 == 0)) isLeapYear = true;
        }
        String output = "";
        for (int i=0; i<7; i++) 
        {
            output += Integer.toString(daysOfWeek[i]) + " ";
        }
        out.println(output.trim());
        out.close();
    }
    
}
