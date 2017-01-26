/*
ID: mchensd
LANG: JAVA
PROG: ariprog
 */
/**
 *
 * @author Michael
 */


import java.util.*;
import java.io.*;

public class ariprog {
    
    public static class Sequence implements Comparable<Sequence>{
        private int a, b;
        public Sequence(int a, int b) {
            this.a = a;
            this.b = b;
        }
        
        public int compareTo(Sequence other) {
            if (this.b < other.b) return -1;
            else if (this.b == other.b) {
                return (this.a < other.a) ? -1 : 1;
            }
            
            else return 1;
        }
    }
    static int N;
    static int M;
    static int numUnique;
    static int[] bisquares;
    static boolean[] hasbi;
    static Sequence[] sols;
    
    
    public static boolean isAriProg(int bisquare, int b, int n) {
        if (n == N) return true;
        if (hasbi[bisquare+b]) {
            return isAriProg(bisquare+b, b, n+1);
        }
        return false;
    }
    
    public static ArrayList<Integer> solve(int ind) {
        // find all arithmetic progressions of bisquares starting with bisquare at index ind
        int bisq = bisquares[ind]; 
//        System.out.printf("bisquare: %d\n", bisq);
        ArrayList<Integer> bs = new ArrayList<>();
        for (int i=ind+1; i<numUnique; i++) {
            
            int b = bisquares[i] - bisq;
            if (b != 0) {
//                System.out.println(b);
                if (bisq + (N-1) * b > M*M+M*M) break;
                if (isAriProg(bisq, b, 1)) 
                    bs.add(b);
            }
        }
        
        return bs;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
        BufferedReader bf;
        PrintWriter pw;
        bf = new BufferedReader(new FileReader("ariprog.in"));
        
        N = Integer.parseInt(bf.readLine());
        M = Integer.parseInt(bf.readLine());
        
        // generate bisquares
        bisquares = new int[(M+1) * (M+2) / (2)];
        hasbi = new boolean[1 + M*M + M*M];
//        System.out.println(M*M + M*M);
        int index = 0;
        numUnique = 0;
        for (int i=0; i<=M; i++) {
            for (int j=i; j<=M; j++) {
                int bisq = i*i + j*j;
                if (!hasbi[bisq]) {
//                System.out.println(bisq);
                    bisquares[index++] = bisq;
                    hasbi[bisq] = true;
                    ++numUnique;
                }
            }
        }
        Arrays.sort(bisquares, 0, numUnique);
//        Sequence[] seq = new Sequence[3];
//        seq[0] = new Sequence(3, 4);
//        seq[1] = new Sequence (2, 2);
//        seq[2] = new Sequence(1,4);
//        Arrays.sort(seq);
        
        sols = new Sequence[bisquares.length];
        
        index = 0;
        for (int i=0; i<numUnique; i++) {
            int bisq = bisquares[i];
            ArrayList<Integer> b = solve(i);
            for (int j=0; j<b.size(); j++) {
                sols[index++] = new Sequence(bisq, b.get(j)); // in the end, index will be the length of sols that we need
            }
        }
        
        Arrays.sort(sols, 0, index);
        
        pw = new PrintWriter(new BufferedWriter(new FileWriter("ariprog.out")));
        
        index = 0;
        while (sols[index] != null) {
            pw.printf("%d %d", sols[index].a, sols[index].b);
            pw.println();
            ++index;
//            System.out.println("printing solution");
        }
        if (index == 0) pw.println("NONE");
//        isAriProg(1, 4, 1);
        pw.close();
//        System.out.println(Arrays.toString(bisquares));
//        System.out.println(Arrays.toString(hasbi));

    } // main
    
} //class 
