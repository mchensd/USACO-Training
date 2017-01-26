/*
ID: mchensd
LANG: JAVA
PROG: pprime
 */

/**
 *
 * @author Michael
 */

import java.util.*;
import java.io.*;

public class pprime {
    int a, b;
    int[] palindromes;
    int generatePalindromes() {
        int ind = 0;
        for (int a=1; a<=9; a+=2) { // 1/2 digit
            palindromes[ind++] = a;
            palindromes[ind++] = a*11;
        }
        
        for (int a=1; a<=9; a+= 2) { // 3/4 digit
            for (int b=0; b<=9; b++) {
                palindromes[ind++] = 100 * a + 10 * b + a;
                palindromes[ind++] = 1000*a + 100*b + 10*b + a;
            }
        }
        
        for (int a=1; a<=9; a+= 2) { // 5/6 digit
            for (int b=0; b<=9; b++) {
                for (int c=0; c<=9; c++) {
                    palindromes[ind++] = 10000 * a + 1000 * b + 100 * c + 10 * b + a;
                    palindromes[ind++] = 100000*a + 10000*b + 1000 * c + 100 * c + 10 * b + a;
                }
            }
        }
        
        for (int a = 1; a <= 9; a += 2) { // 7/8 digit
            for (int b = 0; b <= 9; b++) {
                for (int c = 0; c <= 9; c++) { 
                    for (int d=0; d<=9; d++) {
                        palindromes[ind++] = 1000000 * a + 100000 * b + 10000 * c + 1000 * d + 100 * c + 10 * b + a;
                        palindromes[ind++] = 10000000 * a + 1000000 * b + 100000 * c + 10000 * d + 1000* d + 100* c + 10 * b + a;
                    }
                }
            }
        }
        
        System.out.println(ind);
        return ind;
        
    }
    
    boolean isPrime(int n) {
        int sqrt = (int) Math.sqrt((double)n);
        for (int i=2; i<=sqrt; i++) {
            if (n%i == 0) return false;
        }
        
        return true;
    }
    
    void run() throws IOException {
        BufferedReader bf;
        StringTokenizer st;
        PrintWriter pw;
        
        bf = new BufferedReader(new FileReader("pprime.in"));
        st = new StringTokenizer(bf.readLine());
        String tmpa = st.nextToken();
        String tmpb = st.nextToken();
        
        a = Integer.parseInt(tmpa);
        b = Integer.parseInt(tmpb);
        int lena = tmpa.length();
        int lenb = tmpb.length();
        palindromes = new int[100000];
        int num = generatePalindromes();
        
        Arrays.sort(palindromes, 0, num);
        
        pw = new PrintWriter(new BufferedWriter(new FileWriter("pprime.out")));
        for (int i=0; i<num; i++) {
            if (palindromes[i] >= a && palindromes[i] <= b && isPrime(palindromes[i])) {
                pw.println(palindromes[i]);
            }
            
            else if (palindromes[i] > b) break;
        }
        pw.close();
        
    }
    public static void main(String[] args) throws IOException {new pprime().run();}

}

