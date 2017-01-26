/*
ID: mchensd
LANG: JAVA
PROG: gift1
 */
/**
 *
 * @author Michael
 */
import java.util.*;
import java.io.*;

public class gift1 {
    
    public static class Person {
        private int money = 0;
        private final String name;
        
        private Person(String name) {
            this.name = name;
        }
    }// end Person
    public static void giveMoney(Person giver, Person receiver, int amount) {
        // Give amount money from giver to receiver
        giver.money -= amount;
        receiver.money += amount;
    } // end giveMoney
    
    public static void main(String[] args) throws IOException {
        /* 
        Initialize arry of Students size NP, the first line
        Create hashmap with each name referencing its index
        Get the giver, receivers, amount to each receiver, and remainder
        */
        BufferedReader f;
        PrintWriter out;
        f = new BufferedReader(new FileReader("gift1.in"));
        out = new PrintWriter(new BufferedWriter(new FileWriter("gift1.out")));
        
        int NP = Integer.parseInt(f.readLine());
        
        Person[] people = new Person[NP];
        
        // initialize map to keep track of indicies
        Map<String, Integer> indicies = new HashMap<>();
        
        for (int i=0; i<NP; i++)  // add each person to the array, map them to their indicies
        {
            Person temp;
                       
            String pName = f.readLine();
            indicies.put(pName, i);
            
            temp = new Person(pName);
            people[i] = temp;                 
        } // endfor
        
        for (int i=0; i<NP; i++)  // each giver gives their split of money
        {
            Person giver;
            giver = people[indicies.get(f.readLine())];
            
            //String giver = f.readLine();
            //int giverIndex = indicies.get(giver);
            
            StringTokenizer st = new StringTokenizer(f.readLine());
            int totalMoney = Integer.parseInt(st.nextToken());
            int numberSplit = Integer.parseInt(st.nextToken());
            if (numberSplit == 0) continue;
            
            int toGive = totalMoney / numberSplit;
            
            for (int j=0; j<numberSplit; j++) // each receiver receives their split of money
            {
                Person receiver;
                receiver = people[indicies.get(f.readLine())];
                
                giveMoney(giver, receiver, toGive);
            }
        } // endfor
        
        // Writing to our output file
        for (Person p : people) 
        {
            out.printf("%s %d", p.name, p.money);
            out.println();
        }
        out.close();
    } // main
} // gift1


