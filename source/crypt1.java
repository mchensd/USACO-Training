/*
ID: mchensd
LANG: JAVA
PROG: crypt1
 */

/**
 *
 * @author Michael
 */
import java.util.*;
import java.io.*;

public class crypt1 {

    /**
     * @param args the command line arguments
     */
    public static boolean find(int[] a, int x) {
        for (int i=0; i<a.length; i++) {
            if (a[i] == x) return true;
        }
        return false;
    }
    
    public static boolean allIn(String s, int[] a) {
        for (char c : s.toCharArray()) { // for each digit
            if (!find(a, Integer.parseInt(Character.toString(c)))) return false;
        }
        
        return true;
    }
    
    public static boolean crypt(int[] digs, int a, int b, int c, int d, int e) {
        String p1, p2;  // partial solution 1, partial solution 2
        int abc = a*100 + b*10 + c;
        
        p1 = Integer.toString(abc * d);
        p2 = Integer.toString(abc * e);
        
        if (p1.length() > 3 || p2.length() > 3 || !allIn(p1, digs) || !allIn(p2, digs)) return false;
        
        int pi1 = Integer.parseInt(p1);
        int pi2 = Integer.parseInt(p2);
        pi2 *= 10;
        String prod = Integer.toString(pi1 + pi2);
        return allIn(prod, digs);
    }
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        BufferedReader bf = new BufferedReader(new FileReader("crypt1.in"));
        PrintWriter pw;
        StringTokenizer st;
        int N = Integer.parseInt(bf.readLine());
        
        st = new StringTokenizer(bf.readLine());
        
        int[] digits = new int[N];
        for (int i=0; i<N; i++) {
            digits[i] = Integer.parseInt(st.nextToken());
        }
        
        int count = 0;
        for (int a : digits) {
            for (int b : digits) {
                for (int c : digits) {
                    for (int d : digits) {
                        for(int e : digits) {
                            if (crypt(digits, a, b, c, d, e)) ++count;
                        }
                    }
                }
            }
        }
        pw = new PrintWriter(new BufferedWriter(new FileWriter("crypt1.out")));
        pw.println(count);
        pw.close();
    } // main
    
} // class
