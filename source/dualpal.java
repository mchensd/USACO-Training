/*
ID: mchensd
LANG: JAVA
PROG: dualpal
 */
/**
 *
 * @author Michael
 */
import java.util.*;
import java.io.*;
public class dualpal {

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
        StringTokenizer st;
        PrintWriter pw;
        
        bf = new BufferedReader(new FileReader("dualpal.in"));
        pw = new PrintWriter(new BufferedWriter(new FileWriter("dualpal.out")));
        
        st = new StringTokenizer(bf.readLine());    
        int req = Integer.parseInt(st.nextToken());
        int check = Integer.parseInt(st.nextToken()) + 1;
        
        while (req != 0)
        {
            int numPalindromes = 0;
            for (int i=2; i<=10; i++)  // i is the base to convert to
            {
                if (isPalindrome(Integer.toString(check, i))) ++numPalindromes;
            } // end for
            
            if (numPalindromes >= 2) { pw.println(check); --req; }
            ++check;
        }  // end while
        pw.close();
        
    }
    
    
}
