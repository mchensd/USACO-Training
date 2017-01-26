/*
ID: mchensd
LANG: JAVA
PROG: milk2 
 */
/**
 *
 * @author Michael
 */
import java.util.*;
import java.io.*;
public class milk2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        BufferedReader bf;
        PrintWriter pw;
        StringTokenizer st;
        
        bf = new BufferedReader(new FileReader("milk2.in"));
        int n = Integer.parseInt(bf.readLine());
        boolean[] milkTimes = new boolean[1000000];
        int minTime = 1000001;
        int maxTime = -1;
        for (int i=0; i<n; i++)
        {
            st = new StringTokenizer(bf.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            if (start < minTime) minTime = start;
            if (end > maxTime) maxTime = end;
            for (int j=start; j<end; j++)
            {
                milkTimes[j] = true;
            }
        } // end for
        
        boolean milking = milkTimes[minTime];
        int li = minTime; // lower index
        int ui; // upper index
        int maxMilkStreak = 0;
        int maxBreakStreak = 0;
        for (int i=minTime; i<maxTime; i++)
        {
            if (milkTimes[i] && !milking) { // nobody was milking
                ui = i-1;
                int breakTime = ui - li + 1;
                if (breakTime > maxBreakStreak) maxBreakStreak = breakTime;
                li = i;
                milking = true;
            }
            
            else if (milking && !milkTimes[i]) { // there was somebody milking, now there isn't
                ui = i-1;
                int milkTime = ui - li + 1;
                if (milkTime > maxMilkStreak) maxMilkStreak = milkTime;
                li = i;
                milking = false;
            }
        }
        // we need to check one last time
        ui = maxTime-1;
        //System.out.printf("%d %d\n", li, ui);
        int lastStreak = ui-li+1;
        if (milking) maxMilkStreak = (lastStreak > maxMilkStreak) ? lastStreak : maxMilkStreak;
        else maxBreakStreak = (lastStreak > maxBreakStreak) ? lastStreak : maxBreakStreak;
        /*
        
        for (int i=minTime; i<maxTime+1; i++)
        {
            if (milking && !milkTimes[i]) { // switch from milking to nobody milking
                ui = i-1;
                int milkTime = ui-li+1;
                li = ui;
                if (milkTime > maxMilkStreak) maxMilkStreak = milkTime;
                
                milking = false;
            }
            
            else if (!milking && milkTimes[i]) { // switch from nobody milking to somebody milking
                ui = i;
                int breakTime = ui-li+1;
                li = ui;
                if (breakTime > maxBreakStreak) maxBreakStreak = breakTime;  
                milking = true;
            }
        }*/
        
        
        pw = new PrintWriter(new BufferedWriter(new FileWriter("milk2.out")));
        pw.printf("%d %d", maxMilkStreak, maxBreakStreak);
        pw.println();
        pw.close();
    }
    
}
