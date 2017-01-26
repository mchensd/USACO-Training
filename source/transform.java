/*
ID: mchensd
LANG: JAVA
PROG: transform
 */
/**
 *
 * @author Michael
 */
import java.util.*;
import java.io.*;

public class transform {
    static int boardSize;
    
    public static String rotate90(String pattern) {
        String transformed = "";
        
        for (int i=boardSize*(boardSize-1); i<boardSize*boardSize; i++)
        {
            for (int j=0; j<boardSize*boardSize; j+=boardSize)
            {
                transformed += Character.toString(pattern.charAt(i-j));
            }
        }
        
        return transformed;/*
        for (int i=0; i<boardSize; i++)
        {
            int col = boardSize-1 - i;
            for (int j=0; j<boardSize; j++)
            {
                
            } // end inner
        } // end for
        for (int i=6; i<9; i++)
        {
            for (int j=0; j<7; j+=3)
            {
                transformed += Character.toString(pattern.charAt(i-j));
            } // innerfor
        } // outerfor
        return transformed;*/
    }
    
    public static String reflectHoriz(String pattern) {
        String transformed = "";
        
        for (int i=boardSize-1; i<boardSize*boardSize; i+=boardSize)
        {
            for (int j=0; j<boardSize; j++)
            {
                transformed += Character.toString(pattern.charAt(i-j));
            }
        }
        return transformed;
   
    }
    public static boolean rotatesInto(String original, String transformed, int n) {
        // does original rotate into transformed with n 90 degree rotations?
        
        for (int i=0; i<n; i++)
        {
            original = rotate90(original);
        }
        
        return original.equals(transformed);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        BufferedReader bf;
        PrintWriter pw;
        StringTokenizer st;
        
        bf = new BufferedReader(new FileReader("transform.in"));
        boardSize = Integer.parseInt(bf.readLine());
        
        // initializing the patterns
        String originalPat = "";
        String transfPat = "";
        for (int i=0; i<boardSize; i++)
        {
            originalPat += bf.readLine();
        }
        
        for (int i=0; i<boardSize; i++)
        {
            transfPat += bf.readLine();
        }
        
        boolean found = false;
        int transfNum = 0;
        
        
        
        // check rotations first
        for (int i=1; i<4; i++)
        {
            if (rotatesInto(originalPat, transfPat, i)) {
                transfNum = i;
                found = true;
                break;
            }
        }

        //now check reflection
        if (!found) {
           if (reflectHoriz(originalPat).equals(transfPat)) {
               transfNum = 4;
               found = true;
           }
        } // end reflection check

        if (!found) {
            // combination check
            String reflectedPat = reflectHoriz(originalPat);
            for (int i=1; i<4; i++)
            {
                if (rotatesInto(reflectedPat, transfPat, i)) {
                    transfNum = 5;
                    found = true;
                    break;
                }
            } // end for
        }// end combination check
        
        if (!found && originalPat.equals(transfPat)) {
            found = true;
            transfNum = 6;
        } 
            
        if (!found) transfNum = 7;
         // end else
        
        pw = new PrintWriter(new BufferedWriter(new FileWriter("transform.out")));
        pw.println(transfNum);
        pw.close();
    } //end main;
    
    
} // end class
