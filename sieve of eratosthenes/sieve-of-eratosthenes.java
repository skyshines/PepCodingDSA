import java.util.*;

public class Main {
    
    // ~~~~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~~
    public static void printPrimeUsingSieve(int n) {
        //Given upper range = n;
        //step 1 : create boolean array of size n + 1 because indexing happens from 0 to n 
        boolean[] isprime = new boolean[n + 1];
        
        //step 2 : fill the boolean array with true (ulta bhi soch sakte hai like false wale phir answer consider ho jayene)
        Arrays.fill(isprime, true);
        
        //step 3 : for i loop from 2 to sq root(n)
        //0 and 1 not considered in prime factor counting
        //sq root isliye since factors repeat hote hai and equal clause bhi aayega
        for(int i = 2; i * i <= isprime.length; i++){
            if(isprime[i] == true){
                /*
                the inner for loop will unmark all the factors of current i,
                starting from twice of i till end by taking jumps of i;
                */
                for(int j = i + i; j < isprime.length; j += i){
                    isprime[j] = false;
                }
            }
        }
        
        //now our boolean array is ready we can either do as what the question here says
        //or we can answer our q queries on number n answer which one is prime or not in O(1) time
        
        for(int i = 2; i < isprime.length; i++){
            if(isprime[i] == true) System.out.print(i + " ");
        }
        
        System.out.println();
    }

    // ~~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~
    public static void main(String[] args) {   
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        printPrimeUsingSieve(n);
    }
}
