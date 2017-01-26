/*
ID: mchensd
LANG: JAVA
PROG: wormhole
 */
/**
 *
 * @author Michael
 */
import java.util.*;
import java.io.*;

public class wormhole {
    
    static int n;
    static int[] X, Y, to_the_right, pairings;
    
    public static boolean isInfinite() {
        for (int start = 1; start <= n; start++) { // the starting position
            int pos = start;
            for (int i=0; i<n; i++) {
                pos = to_the_right[pairings[pos]];
            }
            if (pos != 0) return true;
        }
        return false;
    }
    
    public static int solve() {
        int i, total = 0;
        for (i=1; i<=n; i++) {
            if (pairings[i] == 0) break;
        }
        
        if (i > n) {  // base case
            return (isInfinite()) ? 1 : 0;
        }
        
        for (int j=i+1; j<=n; j++) {
            if (pairings[j] == 0) {
                pairings[i] = j;
                pairings[j] = i;
                total += solve();
                pairings[i] = pairings[j] = 0;  // undo everything before our next iteration 
            }
        }
        
        return total;  
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        BufferedReader bf;
        PrintWriter pw;
        StringTokenizer st;
        
        bf = new BufferedReader(new FileReader("wormhole.in"));
        n = Integer.parseInt(bf.readLine());
        
        X = new int[n+1];
        Y = new int[n+1];
        
        for (int i=1; i<=n; i++) {
            st = new StringTokenizer(bf.readLine());
            X[i] = Integer.parseInt(st.nextToken());
            Y[i] = Integer.parseInt(st.nextToken());
        }
        
        to_the_right = new int[n+1];
        for (int i=1; i<=n; i++) {
            int rightCoord = 0;
            for (int j=1; j<=n; j++) {
                if (X[j] > X[i] && Y[i] == Y[j]) {
                    if (rightCoord == 0 || X[j] - X[i] < X[rightCoord] - X[i]) {
                        rightCoord = j;
                    }
                }
            }
            to_the_right[i] = rightCoord;
        }
        pairings = new int[n+1];
        int sols = solve();
        pw = new PrintWriter(new BufferedWriter(new FileWriter("wormhole.out")));
        pw.println(sols);
        pw.close();
        System.out.println(sols);
    } // main
    
} // class
