/*
ID: mchensd
LANG: JAVA
PROG: beads
 */

import java.util.*;
import java.io.*;
public class beads {
    
    public static int[] countBeginning(String necklace, int n) {
        // return int of how long the first sequence is
        int count = 0;
        int wCount = 0;
        int[] ret = {0,0};
        String c = "";
        for (char ch: necklace.toCharArray())
        {
            if (ch == "w".charAt(0)) {
                ret[0]++;
                ret[1]++;
                count++;
                wCount++;
            }
            
            else {
                if (c.equals("")) {
                    c = Character.toString(ch);
                    ret[0]++;
                    ret[1] = 0;
                    count++;
                    wCount = 0;
                }
                
                else if (c.charAt(0) == ch) { 
                    ret[0]++;
                    ret[1] = 0;
                    count++; 
                    wCount = 0; 
                }
                else return ret;
                
            }
            
        }
        return ret;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        BufferedReader f;
        PrintWriter out;
        String necklace;
        
        f = new BufferedReader(new FileReader("beads.in"));
        out = new PrintWriter(new BufferedWriter(new FileWriter("beads.out")));
        
        int n = Integer.parseInt(f.readLine());
        //int n = 29*2;
        necklace = f.readLine();
        necklace += necklace;
        //necklace = "wwwbbrwrbrbrrbrbrwrwwrbwrwrrb";
        //necklace += necklace;
        //System.out.println(countBeginning("wbwbwwrw", 8)[1]);
        //System.out.println(necklace);
        
        int[] befFirstCount = countBeginning(necklace, n);
        int befBreakCount = befFirstCount[0]; // get the length of the first sequence
        int afterBreakCount = 1;
        
        int befWCount = befFirstCount[1];
        int aftWCount = 0;  
        int maxCount = 0;
        
        if (befBreakCount >= n) {out.println(n); out.close();}
        else
        {
        int startI = befBreakCount;
        char counting = necklace.charAt(startI);  // this will never be "w", the countBeginning would have counted it
        int index = startI + 1;
        for (char ch: necklace.substring(startI+1).toCharArray()) 
            /**
             * for each bead:
             * if the bead is what we are counting:
             *      afterBreak++
             * 
             * else if bead not what we are counting:
             *      compare befBreak + afterBreak to maxCount
             *      befBreak = afterBreak
             *      set what we are counting to the different color
             *      
             */
        
        {
            if (ch == counting || ch == "w".charAt(0)) {
                afterBreakCount++;
                if (ch == "w".charAt(0)) aftWCount++;
                else aftWCount = 0;
            }
            
            else {
                if (befBreakCount + afterBreakCount > maxCount) maxCount = befBreakCount + afterBreakCount;
                befBreakCount = afterBreakCount + befWCount;
                befWCount = aftWCount;
                aftWCount = 0;
                afterBreakCount = 1;
                
                counting = ch;                        
            }
            index++;
            
        } // endfor
        //System.out.println(maxCount);
        if (maxCount >= n) {out.println(n); out.close();}
        else{
        out.println(maxCount);
        out.close();
                }
        }
        
    } // end main
    
}
