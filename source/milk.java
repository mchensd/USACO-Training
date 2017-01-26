/*
ID: mchensd
LANG: JAVA
PROG: milk
 */
/**
 *
 * @author Michael
 */
import java.io.*;
import java.util.*;
public class milk {

    public static int minIndex(int[] a) {
        int min = 0;
        for (int i=1; i<a.length; i++) {
            if (a[i] < a[min]) min = i;
        }
        return min;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        BufferedReader bf;
        PrintWriter pw;
        StringTokenizer st;
        
        bf = new BufferedReader(new FileReader("milk.in"));
        st = new StringTokenizer(bf.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        if (n == 0) {
            pw = new PrintWriter(new BufferedWriter(new FileWriter("milk.out")));
            pw.println(0);
            pw.close();
        }
        else {
        int[] amounts = new int[m];
        int[] prices = new int[m];
        for (int i=0; i<m; i++) {
            st = new StringTokenizer(bf.readLine());
            prices[i] = Integer.parseInt(st.nextToken());
            amounts[i] = Integer.parseInt(st.nextToken());
        }
        int cost = 0;
        int minIndex = 0;
        while (n > 0) {
            minIndex = minIndex(prices);  // find the smallest price
            if (n - amounts[minIndex] <= 0) break;
            cost += amounts[minIndex] * prices[minIndex];
            n -= amounts[minIndex];
            prices[minIndex] = 1001;
        }
        
        cost += n*prices[minIndex];
        pw = new PrintWriter(new BufferedWriter(new FileWriter("milk.out")));
        pw.println(cost);
        pw.close();
        }
    }
    
}
