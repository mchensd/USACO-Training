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

public class whatbase {
    
    public static int convToBase10(int number, int currBase)
    {
        int hundreds = number / 100;
        int tens = (number % 100) / 10;
        int ones = (number % 10) % 10;
        return hundreds * currBase * currBase + tens * currBase + ones;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        BufferedReader bf;
        PrintWriter pw;
        StringTokenizer st;
        
        bf = new BufferedReader(new FileReader("whatbase.in"));
        int n = Integer.parseInt(bf.readLine());
        
        pw = new PrintWriter(new BufferedWriter(new FileWriter("whatbase.out")));
        for (int i=0; i<n; i++)
        {
            st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            
            int convertedX = x;
            int convertedY = y;
            
            int xBase = 10;
            int yBase = 10;
            while (convertedX != convertedY)
            {
                if (convertedX < convertedY) convertedX = convToBase10(x, ++xBase);
                else if (convertedY < convertedX) convertedY = convToBase10(y, ++yBase);           
                
            } // end while
            pw.printf("%d %d", xBase, yBase);
            pw.println();
        } // end for
        
      
        pw.close();
    } // end main
    
}
