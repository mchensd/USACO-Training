
import java.io.*;
import java.util.*;
/*
ID: mchensd
LANG: JAVA
PROG: 
 */
/**
 *
 * @author Michael
 */
public class MyUtil {
    public static class Farmer implements Comparable<Farmer> {
        private int p;
        private int a;
        public Farmer(int p, int a) {
            this.p = p;
            this.a = a;
        }
        public int compareTo(Farmer other) {
            return (this.p < other.p) ? -1 : 1;
        }
    }
    
    public static int printStuff(int n, int prev) {
        if (Integer.toString(prev).length() == n) {
            return prev;
        }
        
        else return printStuff(n, prev +10);
    }
    /**
     * 
     * @param <T> generic type
     * @param arr the 2d array
     * @param n number of rows
     * @param m  number of columns
     */
    
    public static void print2d(int[][] arr, int n, int m){  // formats and prints n x m array
        for (int i=0; i<n; i++)
        {
            for (int j=0; j<m; j++)
            {
                System.out.printf("%s ", arr[i][j]);
            } // inner for
            System.out.println();
        } // outer for
            
    } // end print2d
    
    public static void print2d(boolean[][] arr, int n, int m){  // formats and prints n x m array
        for (int i=0; i<n; i++)
        {
            for (int j=0; j<m; j++)
            {
                System.out.printf("%s ", arr[i][j]);
            } // inner for
            System.out.println();
        } // outer for
            
    } // end print2d
    
    public static void print2d(String[][] arr, int n, int m){  // formats and prints n x m array
        for (int i=0; i<n; i++)
        {
            for (int j=0; j<m; j++)
            {
                System.out.printf("%s ", arr[i][j]);
            } // inner for
            System.out.println();
        } // outer for
            
    } // end print2d
    
    public static void print2d(double[][] arr, int n, int m){  // formats and prints n x m array
        for (int i=0; i<n; i++)
        {
            for (int j=0; j<m; j++)
            {
                System.out.printf("%s ", arr[i][j]);
            } // inner for
            System.out.println();
        } // outer for
            
    } // end print2d
    
    public static void main(String[] args) throws IOException {
        System.out.println(printStuff(3, 0));
    }
}

