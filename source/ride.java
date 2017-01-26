/*
ID: mchensd
LANG: JAVA
PROG: ride
 */
import java.io.*;
import java.util.*;
/**
 *
 * @author Michael
 */
class ride {
    
    public static int convertToNum(String s) {
        int num = 1;
        for (char ch : s.toCharArray()) {
            num *= (int) ch - 64;
        }
        return num;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        
        BufferedReader f;
        PrintWriter out;
        String comet;
        String group;
        /*
        f = new BufferedReader(new FileReader("ride.in"));
        out = new PrintWriter(new BufferedWriter(new FileWriter("ride.out")));
        // Use StringTokenizer vs. readLine/split -- lots faster
        StringTokenizer st = new StringTokenizer(f.readLine());
        while ((line = st.nextToken()) != null) {
            out.println(line);
        }
        out.close();
        */
        f = new BufferedReader(new FileReader("ride.in"));
        out = new PrintWriter(new BufferedWriter(new FileWriter("ride.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        StringTokenizer st2 = new StringTokenizer(f.readLine());
        comet = st.nextToken();
        group = st2.nextToken();
        //System.out.println(convertToNum("USACO"));
        int cometNum = convertToNum(comet);
        int groupNum = convertToNum(group);
        System.out.printf("%d\n%d\n", cometNum, groupNum);
        if (cometNum % 47 == groupNum % 47) out.println("GO");
        
        else { out.println("STAY"); }
        
        out.close();
        
        }
    }
   
