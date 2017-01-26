/*
ID: mchensd
LANG: JAVA
PROG: combo
 */
/**
 *
 * @author Michael
 */
import java.util.*;
import java.io.*;
public class combo {

    /**
     * @param args the command line arguments
     */
    public static int intersectionLength(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        
        int count = 0;
        for (int i=0; i<a.length; i++) {
            if (i==0 || a[i] != a[i-1]) {
                if (Arrays.binarySearch(b, a[i]) > -1) ++count;
            }
        }
        return count;
    }
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        BufferedReader bf;
        PrintWriter pw;
        StringTokenizer st1, st2;
        bf = new BufferedReader(new FileReader("combo.in"));
        int n = Integer.parseInt(bf.readLine());
        
        int[] jCom = new int[3];
        int[] mCom = new int[3]; //master combination
        
        st1 = new StringTokenizer(bf.readLine());
        st2 = new StringTokenizer(bf.readLine());
        for (int i=0; i<3; i++) {
            jCom[i] = Integer.parseInt(st1.nextToken());
            mCom[i] = Integer.parseInt(st2.nextToken());
        }
        int overc;
        if (n > 4){
            overc = 250;
        }
        
        else {
            overc = 2 * (n*n*n);
        }
        //now count overlapping cases:
        int overLap = 1;
        for (int i=0; i<3; i++) {
            int j = jCom[i];
            int m = mCom[i];
            int subVal = 2;
            
            int[] jPoss = new int[5]; // posisibilites of the digit
            int[] mPoss = new int[5];
            for (int e=0; e<5; e++) {
                if (j - subVal <= 0) {
                    jPoss[e] = (j-subVal+n);
                    if (jPoss[e] <= 0) jPoss[e] = n;
                }
                else if (j - subVal > n) {
                    jPoss[e] = (j-subVal) % n;
                    if (jPoss[e] == 0) jPoss[e] = n;
                }
                else jPoss[e] = j-subVal;
                
                if (m - subVal <= 0) {
                    mPoss[e] = m-subVal + n;
                    if (mPoss[e] <= 0) mPoss[e] = n;
                }
                else if (m - subVal > n) {
                    mPoss[e] = (m-subVal) % n;
                    if (mPoss[e] == 0) mPoss[e] = n;
                }
                else mPoss[e] = m-subVal;
                --subVal;
            }
            
            overLap *= intersectionLength(jPoss, mPoss);
        }
        int ret = overc - overLap;
        pw = new PrintWriter(new BufferedWriter(new FileWriter("combo.out")));
        pw.println(ret);
        pw.close();
    }
    
}
