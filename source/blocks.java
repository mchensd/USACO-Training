/*
ID: mchensd
LANG: JAVA
PROG: blocks
 */
/**
 *
 * @author Michael
 */
import java.io.*;
import java.util.*;

public class blocks {
    
    public static int maxOf(int a, int b) {
        return (a > b) ? a : b;
    }
    
    public static int lettersIn(String word, char let) {
        int count = 0;
        
        for (char c : word.toCharArray())
        {
            if (c == let) ++count;
        }
        return count;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        BufferedReader bf;
        StringTokenizer st;
        PrintWriter pw;
        
        bf = new BufferedReader(new FileReader("blocks.in"));
        int n = Integer.parseInt(bf.readLine());
        String[] boards = new String[2*n]; // even indexes mark the beginning of a new board
        
        for (int i=0; i<2*n; i+=2)
        {
            st = new StringTokenizer(bf.readLine());
            boards[i] = st.nextToken();
            boards[i+1] = st.nextToken();
        }
        
        char[] letters = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        
        pw = new PrintWriter(new BufferedWriter(new FileWriter("blocks.out")));
        for (char let : letters)
        {
            int nb = 0; // number of blocks
            for (int i=0; i<2*n; i+=2)
            {
                
                nb += maxOf(lettersIn(boards[i], let), lettersIn(boards[i+1], let));
            } // end inner
            pw.println(nb);
        } // end for
        pw.close();
    } // end main
    
}
