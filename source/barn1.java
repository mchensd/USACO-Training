/*
ID: mchensd
LANG: JAVA
PROG: barn1
 */
/**
 *
 * @author Michael
 */
import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class barn1 {
    
    public static int[] findNBiggest(int[] a, int n) {
        // return array of n biggest elements in a in the order they are found
        
        int[] sorteda = Arrays.copyOf(a, a.length);
        Arrays.sort(sorteda);
        
        int[] maxN = new int[n];
        for (int i=0; i<n; i++) {
            maxN[i] = sorteda[a.length-1-i];
           
        }
        
        int[] finalMaxN = new int[n];
        int p = 0;
        for (int i=0; i<a.length; i++) {
            int diff = a[i];
            if (IntStream.of(maxN).anyMatch(x -> x == diff)) {
                finalMaxN[p++] = diff;
                removeFrom(maxN, diff);
                if (p == n) break;
            }
        }
        return finalMaxN;
    }
    
    public static void removeFrom(int[] a, int n) {
        // remove n from array a
        for (int i=0; i<a.length; i++) {
            if (a[i] == n) {
                a[i] = 501;
                break;
            }
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        BufferedReader bf;
        PrintWriter pw;
        StringTokenizer st;
        
        bf = new BufferedReader(new FileReader("barn1.in"));
        st = new StringTokenizer(bf.readLine());
        
        int m = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        
        int[] stalls = new int[c];
        for (int i=0; i<c; i++) {
            stalls[i] = Integer.parseInt(bf.readLine());
        }
        
        
        Arrays.sort(stalls);
        if (m == 1) {
            pw = new PrintWriter(new BufferedWriter(new FileWriter("barn1.out")));
            pw.println(stalls[stalls.length-1] - stalls[0] + 1);
            pw.close();
        }
        
        else if (m >= stalls.length) {
            pw = new PrintWriter(new BufferedWriter(new FileWriter("barn1.out")));
            pw.println(c);
            pw.close();
        }
        else {
        int[] diffs = new int[c];
        for (int i=0; i<stalls.length-1; i++) {
            diffs[i] = stalls[i+1] - stalls[i];
        }
        
        
        int[] maxN = findNBiggest(diffs, m-1);
        int p = 0;
        
        int begi = 0;
        int endi;
        int numCovered = 0;
        for (int i=0; i<stalls.length-1; i++) {
            if (stalls[i+1] - stalls[i] == maxN[p]) {
                ++p;
                endi = i;
                numCovered += stalls[endi] - stalls[begi] + 1;
                
                begi = i+1;
                if (p == maxN.length) break;
            }
        } // end for
        if (begi < c) {
            numCovered += stalls[c-1] - stalls[begi] + 1;
        }
        
        pw = new PrintWriter(new BufferedWriter(new FileWriter("barn1.out")));
        pw.println(numCovered);
        pw.close();
        }
    } // main
}
