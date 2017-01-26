/*
ID: mchensd
LANG: JAVA
PROG: numtri
 */

/**
 *
 * @author Michael
 */

import java.util.*;
import java.io.*;

public class numtri {
    int[][] tree, dp;
    int n;
    
    void solveDP(int i, int j) {
        dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + tree[i-1][j-1];
    }
    
    int maxOfArray(int[] a) {
        int max = -1;
        for (int i=0; i<a.length; i++) {
            max = Math.max(a[i], max);
        }
        
        return max;
    }
    void run() throws IOException {
        BufferedReader bf;
        StringTokenizer st;
        PrintWriter pw;
        
        bf = new BufferedReader(new FileReader("numtri.in"));
        n = Integer.parseInt(bf.readLine());
        tree = new int[n][n];
        dp = new int[n+1][n+1];
        
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j=0; j<=i; j++) {
                tree[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
//        MyUtil.print2d(tree, n, n);
        dp[1][1] = tree[0][0];
        
        for (int i=2; i<=n; i++) {
            for (int j=1; j<=i; j++) {
                solveDP(i, j);
            }
        }
        
        int ans = maxOfArray(dp[n]);
//        MyUtil.print2d(dp, n+1, n+1);
        pw = new PrintWriter(new BufferedWriter(new FileWriter("numtri.out")));
        pw.println(ans);
        pw.close();
//        System.out.println(ans);
    }
    public static void main(String[] args) throws IOException {new numtri().run();}

}
