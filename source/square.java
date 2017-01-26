/*
ID: mchensd
LANG: JAVA
PROG: square
 */
/**
 *
 * @author Michael
 */
import java.io.*;
import java.util.*;
public class square {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        BufferedReader bf;
        PrintWriter pw;
        StringTokenizer st;
        
        bf = new BufferedReader(new FileReader("square.in"));
        
        int[] minxs = new int[2];
        int[] minys = new int[2];
        int[] maxxs = new int[2];
        int[] maxys = new int[2];
        int minx = 11;
        int miny = 11;
        int maxx = -1;
        int maxy = -1;
        for (int i=0; i<2; i++)
        {
            st = new StringTokenizer(bf.readLine());
            int x1,y1,x2,y2;
            if ((x1 =Integer.parseInt(st.nextToken())) < minx) minx = x1; 
            if ((y1 =Integer.parseInt(st.nextToken())) < miny) miny = y1; 
            if ((x2 =Integer.parseInt(st.nextToken())) > maxx) maxx = x2; 
            if ((y2 =Integer.parseInt(st.nextToken())) > maxy) maxy = y2; 
        } // end for
        
        int xLen = maxx - minx;
        int yLen = maxy - miny;
        int a; // area for the answer
        if (xLen > yLen) a = xLen*xLen;
        else a = yLen*yLen;
        pw = new PrintWriter(new BufferedWriter(new FileWriter("square.out")));
        pw.println(a);
        pw.close();
    } // end main
    
}
