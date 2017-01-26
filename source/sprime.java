/*
ID: mchensd
LANG: JAVA
PROG: sprime
 */

/**
 *
 * @author Michael
 */

import java.util.*;
import java.io.*;

public class sprime {
    int n;
    PrintWriter pw;
    
    boolean isPrime(int n) {
        if (n == 1) return false;
        for (int i=2; i*i <= n; i++) {
            if (n%i == 0) return false;
        }
        
        return true;
    }
    
    void solve(int curr, int len) {
        // solve the superprimerib for the current number, given the current power of 10
        if (len == -1) {
            pw.println(curr);
            return;
        }
        
        for (int i=1; i<=9; i++) {
            int place = (int) Math.pow(10, len);
            int tmp = curr + i * place;
            if (isPrime(tmp / place)) {
                solve(tmp, len-1);
            }
        }
    }
    void run() throws IOException {
        BufferedReader bf;        
        bf = new BufferedReader(new FileReader("sprime.in"));
        pw = new PrintWriter(new BufferedWriter(new FileWriter("sprime.out")));
        n = Integer.parseInt(bf.readLine());
        solve(0, n-1);
        pw.close();
    }
    public static void main(String[] args) throws IOException {new sprime().run();}

}
