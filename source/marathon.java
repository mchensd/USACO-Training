/*
ID: mchensd
LANG: JAVA
PROG: 
 */
/**
 *
 * @author Michael
 */
import java.util.*;
import java.io.*;
public class marathon {
    
    public static int distBetween(int[] c1, int[] c2){
        return Math.abs(c1[0] - c2[0]) + Math.abs(c1[1]-c2[1]);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        BufferedReader bf;
        PrintWriter pw;
        StringTokenizer st;
        
        bf = new BufferedReader(new FileReader("marathon.in"));
        
        int n = Integer.parseInt(bf.readLine());
        
        // setting up coordinates
        int[][] coords = new int[n][2];
        for (int i=0; i<n; i++)
        {
            st = new StringTokenizer(bf.readLine());
            coords[i][0] = Integer.parseInt(st.nextToken());
            coords[i][1] = Integer.parseInt(st.nextToken());
        }
        
        int totDist = 0;
        // calculate total distance
        for (int i=0; i<n-1; i++)
        {
            //int d = distBetween(coords[i], coords[i+1]);
            //totDist += d;
            //System.out.println(d);
            totDist += distBetween(coords[i], coords[i+1]);
        }
        int tempDist; // the temporary distance for every checkpoint we remove
        int minimumDist= totDist; // the final distance to be returned
        for (int i=1; i<n-1; i++)
        {
            tempDist = totDist - distBetween(coords[i], coords[i-1]) - distBetween(coords[i], coords[i+1]) + distBetween(coords[i-1], coords[i+1]);
            if (tempDist < minimumDist) minimumDist = tempDist;
        }
        MyUtil.print2d(coords, n, 2);
        pw = new PrintWriter(new BufferedWriter(new FileWriter("marathon.out")));
        pw.println(minimumDist);
        pw.close();
        
    } // end main
    
}
