/*
ID: mchensd
LANG: JAVA
PROG: mowing
 */
/**
 *
 * @author Michael
 */
import java.util.*;
import java.io.*;
public class mowing {
    
    static int n;
    static int x;
    static int y;
    static int time;
    static int gTime;
    static Integer[][] field;
    
    public static void markXPaths(int chx) {
        int incr = chx/chx; // positive or negative direction?
        if (chx > 0){
            for (int i=1; i<=chx; i++)
            {
                ++time;
                if (field[x+i][y] == null) field[x+i][y] = time;
                else { // the spot was visited
                    int tmpGrowth = time - field[x+i][y];
                    if (tmpGrowth < gTime) gTime = tmpGrowth;
                    field[x+i][y] = time;
                }
            } // end for
        }
        
        else {
            for (int i=-1; i>=chx; i--)
            {
                ++time;
                if (field[x+i][y] == null) field[x+i][y] = time;
                else { // the spot was visited
                    int tmpGrowth = time - field[x+i][y];
                    if (tmpGrowth < gTime) gTime = tmpGrowth;
                    field[x+i][y] = time;
                }
            } // end for
        } // end else
        x += chx;
    }
    
    public static void markYPaths(int chy) {
        if (chy > 0) {
            for (int i=1; i<=chy; i++)
            {
                ++time;
                if (field[x][y+i] == null) field[x][y+i] = time;
                else { // the spot was visited
                    int tmpGrowth = time - field[x][y+i];
                    if (tmpGrowth < gTime) gTime = tmpGrowth;
                    field[x][y+i] = time;
                }
            } // end for
        }
        
        else {
            for (int i=-1; i>=chy; i--)
            {
                ++time;
                if (field[x][y+i] == null) field[x][y+i] = time;
                else { // the spot was visited
                    int tmpGrowth = time - field[x][y+i];
                    if (tmpGrowth < gTime) gTime = tmpGrowth;
                    field[x][y+i] = time;
                }
            } // end for
        }
        y += chy;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        BufferedReader bf;
        PrintWriter pw;
        StringTokenizer st;
        
        bf = new BufferedReader(new FileReader("mowing.in"));
        
        n = Integer.parseInt(bf.readLine());
        time = 0; // current time
        x = 1000;
        y = 1000;
        field = new Integer[2001][2001];
        
        field[x][y] = time;
        gTime = Integer.MAX_VALUE; // growth time
        for(int i=0; i<n; i++)
        {
            st = new StringTokenizer(bf.readLine());
            String dir = st.nextToken();
            int s = Integer.parseInt(st.nextToken());
            
            int chx = 0;
            int chy = 0;
            switch (dir) {
                case "N":
                    chx -= s;
                    break;
                case "S":
                    chx += s;
                    break;
                case "E":
                    chy += s;
                    break;
                case "W":
                    chy -= s;
                    break;
                default:
                    break;
            }
            if (chx != 0) markXPaths(chx);
            else if (chy != 0) markYPaths(chy);
            
            
        } // end for
        pw = new PrintWriter(new BufferedWriter(new FileWriter("mowing.out")));
        if (gTime == Integer.MAX_VALUE) gTime = -1;
        pw.println(gTime);
        pw.close();
        
    }
    
}
