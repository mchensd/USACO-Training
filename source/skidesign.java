/*
ID: mchensd
LANG: JAVA
PROG: skidesign
 */
/**
 *
 * @author Michael
 */
import java.util.*;
import java.io.*;
public class skidesign {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        BufferedReader bf;
        PrintWriter pw;
        
        bf = new BufferedReader(new FileReader("skidesign.in"));
        
        int n = Integer.parseInt(bf.readLine());
        
        int[] h = new int[n];
        for (int i=0; i<n; i++) {
            h[i] = Integer.parseInt(bf.readLine());
        }
        
        int mincost = Integer.MAX_VALUE;
        for (int lb=0; lb<84; lb++) {
            int cost = 0;
            
            int ub = lb + 17;
            
            int x;
            for (int i=0; i<n; i++) {
                if (h[i] < lb) x = lb - h[i];
                else if (h[i] > ub) x = h[i] - ub;
                else x = 0;
                cost += x*x;
            }
            mincost = Math.min(cost, mincost);
            
        }
        pw = new PrintWriter(new BufferedWriter(new FileWriter("skidesign.out")));
        pw.println(mincost);
        pw.close();
        System.out.println(mincost);
    }
    
}
