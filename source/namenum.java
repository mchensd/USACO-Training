/*
ID: mchensd
LANG: JAVA
PROG: namenum
 */
/**
 *
 * @author Michael
 */
import java.io.*;
import java.util.*;
public class namenum {
    
    public static boolean canTranslate(String serial, String name) {
        // can the serial number be translated into the name
        String[] ts = new String[]{null, null, "ABC", "DEF", "GHI", "JKL", "MNO", "PRS", "TUV", "WXY"}; // translations, indexes are the numbers, strings are possible chars
        for (int i=0; i<name.length(); i++)
        {
            String let = Character.toString(name.charAt(i));
            int num = Integer.parseInt(Character.toString(serial.charAt(i))); 
            if (!ts[num].contains(let)) return false;
            
        }
        
        return true;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        BufferedReader bf, nr; // name reader
        PrintWriter pw;
        StringTokenizer st;
        
        
        bf = new BufferedReader(new FileReader("namenum.in"));
        nr = new BufferedReader(new FileReader("dict.txt"));
        pw = new PrintWriter(new BufferedWriter(new FileWriter("namenum.out")));
        
        String serial = bf.readLine();
        int sLen = serial.length(); // lenght of name of cow
        
        String name;
        boolean hasName = false;
        while ((name = nr.readLine()) != null)
        {
            if (name.length() == sLen) {
                if (canTranslate(serial, name)) {
                    pw.println(name);
                    hasName = true;
                }
                
            }
        } // end while
        if (!hasName) pw.println("NONE");
        pw.close();
    }
    
}
