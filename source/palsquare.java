/*
ID: mchensd
LANG: JAVA
PROG: palsquare
 */
/**
 *
 * @author Michael
 */
import java.util.*;
import java.io.*;
public class palsquare {
    
    public static boolean isPalindrome(String s) {
        if (s.length() <= 1) return true;
        
        if (s.charAt(0) == s.charAt(s.length()-1)) {
            return isPalindrome(s.substring(1, s.length()-1));
        }
        
        else return false;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        BufferedReader bf;
        PrintWriter pw;
        
        bf = new BufferedReader(new FileReader("palsquare.in"));
        pw = new PrintWriter(new BufferedWriter(new FileWriter("palsquare.out")));
        
        int b = Integer.parseInt(bf.readLine());
            
        for (int i=1; i<=300; i++) {
            String baseB = Integer.toString(i, b).toUpperCase();
            String bSqr = Integer.toString(i*i, b).toUpperCase();
            if (isPalindrome(bSqr)) {
                pw.printf("%s %s", baseB, bSqr);
                pw.println();
            }
        } // end for
        
        pw.close();
        
    } //end main
    
}
