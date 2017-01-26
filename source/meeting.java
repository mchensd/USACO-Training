/*
ID: mchensd
LANG: JAVA
PROG: meeting
 */
/**
 *
 * @author Michael
 */
import java.io.*;
import java.util.*;
public class meeting {
    
    public static int[][] bessieTimes;
    public static int[][] elsieTimes;
    public static boolean[] bessieCan;
    public static boolean[] elsieCan;
    
    public static int n;
        

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        BufferedReader bf;
        PrintWriter pw;
        StringTokenizer st;
        
        bf = new BufferedReader(new FileReader("meeting.in"));
        st = new StringTokenizer(bf.readLine());
        
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        bessieTimes = new int[n][n];
        elsieTimes = new int[n][n];
        
        for (int i=0; i<m; i++)
        {
            st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            
            bessieTimes[x-1][y-1] = Integer.parseInt(st.nextToken());
            elsieTimes[x-1][y-1] = Integer.parseInt(st.nextToken());
        }
        
        bessieCan = new boolean[10];
        elsieCan = new boolean[10];
        
        findAllTimes(bessieTimes, bessieCan, 0, 0);  // find all times given the distances between points, the starting point, and the 
        // beginning time (0)
        findAllTimes(elsieTimes, elsieCan, 0, 0);
        
        int best = 0;
        for (int i=0; i<10; i++)
        {
            if (bessieCan[i] && elsieCan[i]) { best=i; break; }
        }
        System.out.println(best);
        MyUtil.print2d(bessieTimes, n, n);
        MyUtil.print2d(elsieTimes, n, n);
        System.out.println(Arrays.toString(bessieCan));
        System.out.println(Arrays.toString(elsieCan));
    } // end main
    
    public static void findAllTimes(int[][] times, boolean[] cans, int startPos, int currTime) {
        if (startPos == n-1) { // we are at starting at the end, so we are done
            cans[currTime] = true;
            System.out.printf("Base case currTime: %d\n", currTime);
            return;
        }
        
        for (int i=startPos+1; i<n; i++)
        {
            System.out.printf("%d %d %d\n", startPos, i, times[startPos][i]);
            
            currTime += times[startPos][i];
            System.out.printf("Current time: %d\n", currTime);
            findAllTimes(times, cans, i, currTime);
        }
        
        
    } // end findAllTimes
}
