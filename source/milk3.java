/*
ID: mchensd
LANG: JAVA
PROG: milk3
 */

/**
 *
 * @author Michael
 */

import java.util.*;
import java.io.*;

public class milk3 {
    
    int[] maxes, buckets;
    int[] sols;
    boolean[][][] visited;
    boolean[] hasSol;
    int n; // number of solutions
    
    boolean uniquePour(int i, int j, int previ, int prevj) {
        if (i != j && buckets[i] != 0) {
            return !(i == previ && j == prevj || i == prevj && j == previ);
        }
        return false;
//        return (i!=j && (i!=previ && j!=prevj || i!=prevj && j!=previ) && buckets[i] != 0);
    }
    int pour(int a, int b) {
        // pour milk from bucket a into bucket b
        int amount;
        if (buckets[b] + buckets[a] > maxes[b]) {  // case 1: second bucket filled
            amount = maxes[b] - buckets[b];
            buckets[a] -= amount;
            buckets[b] = maxes[b];
        }
        
        else {  // case 2: first bucket empty
            amount = buckets[a];
            buckets[b] += amount;
            buckets[a] = 0;
        }
        return amount;
    }
    
    void dfs(int previ, int prevj) {
        int a = buckets[0];
        int b = buckets[1];
        int c = buckets[2];
//        System.out.printf("a: %d b: %d c: %d\n", a, b, c);

        if (visited[a][b][c]) {
            return;
        }

//        System.out.printf("a: %d b: %d c: %d\n", a, b, c);
        if (a == 0 && !hasSol[c]) {
            sols[n++] = c;
            hasSol[c] = true;
        }
        
        visited[a][b][c] = true;    

        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                if (uniquePour(i, j, previ, prevj)) {
//                    System.out.printf("pouring bucket %d into bucket %d\n", i, j);
                    int amount = pour(i, j);  // bucket i into bucket j
                    dfs(i, j);
                    buckets[i] += amount; buckets[j] -= amount;
//                    visited[a][b][c] = true;
//                    pour(j, i);  // pour bucket j back into bucket i
                }
            }
        }
        
//        System.out.println("for loop done");
    }
    void run() throws IOException {
        BufferedReader bf;
        StringTokenizer st;
        PrintWriter pw;
        
        bf = new BufferedReader(new FileReader("milk3.in"));
        
        maxes = new int[3];
        st = new StringTokenizer(bf.readLine());
        for (int i=0; i<3; i++) {
            maxes[i] = Integer.parseInt(st.nextToken());
        }
        
        buckets = new int[3];
        buckets[2] = maxes[2];
        
        visited = new boolean[21][21][21];
//        visited[0][0][buckets[2]] = true;
        hasSol = new boolean[21];
        sols = new int[21];
        n = 0;
        dfs(-1, -1);
        
        Arrays.sort(sols, 0, n);
        
        String ans = "";
        for (int i=0; i<n; i++) {
            ans += Integer.toString(sols[i]);
            ans += " ";
        }
        ans = ans.trim();
        
        pw = new PrintWriter(new BufferedWriter(new FileWriter("milk3.out")));
        pw.println(ans);
        pw.close();
//        System.out.println(Arrays.toString(sols));
    }
    public static void main(String[] args) throws IOException { new milk3().run(); }

}
