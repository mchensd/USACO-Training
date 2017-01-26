/*
ID: mchensd
LANG: JAVA
PROG: badmilk
 */
/**
 *
 * @author Michael
 */
import java.util.*;
import java.io.*;

public class badmilk {
    /**
     * class Person:
     *      map drinkTimes: key - time, value - milkType
     * 
     * Get first line of input
     * initialize array of size N to keep track of instances of People (Person p is at index p-1)
     * for i in range(D):
     *      person[p-1].setDrankAtTime(milkType, time);  // 
     * 
     * int maxSick = 0
     * for i in range(S):
     *          int currSick
     *          contaminatedMilks = person[p-1].drankMilksBefore(t)
     *          for each person p:
     *              if p.drankMliks(contaimnatedMilks):
     *                  currSick++
     *          
     *          compare currSick > maxSick
     */
    
    public static class Person {
        private List<List<Integer>> milkTypeTimes = new ArrayList<List<Integer>>();  // 2d arraylist, each value is {milkType, time}
        
        public void setDrankAtTime(int milkType, int time)
        {
            List<Integer> drinkRecord = new ArrayList<>(Arrays.asList(milkType, time));
            milkTypeTimes.add(drinkRecord);
        } 
        
        public List<Integer> milksDrankBefore(int time)
        {
            List<Integer> milksDrank = new ArrayList<>();
            for (int i=0; i<milkTypeTimes.size(); i++)
            {
                if (milkTypeTimes.get(i).get(1) < time) milksDrank.add(milkTypeTimes.get(i).get(0));
            } // endfor
            
            return milksDrank;
        }
        
        public boolean drankMilks(List<Integer> milks){  // return true if Person drank at least one of the milks in the list of milks
            for (int milkType : milks)
            {
                for (int i=0; i<milkTypeTimes.size(); i++)
                {
                    if (milkTypeTimes.get(i).get(0) == milkType) return true;
                } // end inner for
            } // end outer for
            
            return false;
        }
    } // end Person
    
    
    public static void main(String[] args) throws IOException {
        BufferedReader bf;
        StringTokenizer st;
        PrintWriter pw;
        Person[] people;
    
        bf = new BufferedReader(new FileReader("badmilk.in"));
        st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        people = new Person[n];
        for (int i=0; i<n; i++)
        {
            people[i] = new Person();
        }
        int m = Integer.parseInt(st.nextToken());
        
        int d = Integer.parseInt(st.nextToken());
        
        int s = Integer.parseInt(st.nextToken());
        //System.out.println(bf.readLine());
        for (int i=0; i<d; i++)
        {
            StringTokenizer stTemp = new StringTokenizer(bf.readLine());
            int pIndex = Integer.parseInt(stTemp.nextToken()) - 1;
            int milkType = Integer.parseInt(stTemp.nextToken());
            int time = Integer.parseInt(stTemp.nextToken());
            
            people[pIndex].setDrankAtTime(milkType, time);
        }
        
        int maxSick = 0;
        for (int i=0; i<s; i++) 
        {
            StringTokenizer stTmp = new StringTokenizer(bf.readLine());
            int currSick = 0;
            
            int pIndex = Integer.parseInt(stTmp.nextToken()) - 1;
            int timeSick = Integer.parseInt(stTmp.nextToken());
            
            List<Integer> contaminatedMilk = people[pIndex].milksDrankBefore(timeSick);
            for (Person p: people)
            {
                if (p.drankMilks(contaminatedMilk)) currSick++;
            }
            maxSick = (currSick > maxSick) ? currSick : maxSick;
        } // endfor
        
        pw = new PrintWriter(new BufferedWriter(new FileWriter("badmilk.out")));
        pw.println(maxSick);
        pw.close();
        
    }// end main
    
    
    
} // end badmilk
