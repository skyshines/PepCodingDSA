//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            double avg = sc.nextDouble ();
            int[] roll = new int[n];
            int[] marks = new int[n];
            
            for (int i = 0; i < n; ++i)
                roll[i] = sc.nextInt ();
                
            for (int i = 0; i < n; ++i)
                marks[i] = sc.nextInt ();

    		System.out.println (new Solution().shouldPunish (roll, marks, n, avg));
        }
        
    }
}

// Contributed By: Pranay Bansal
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public static int shouldPunish (int roll[], int marks[], int n, double avg)
    {
        int swaps = 0;
        
        for(int i = 1; i <= roll.length - 1; i++){
            for(int j = 0; j < roll.length - i; j++){
                if(roll[j] > roll[j + 1]){
                    int temp = roll[j];
                    roll[j] = roll[j + 1];
                    roll[j + 1] = temp;
                    
                    swaps += 2;
                }
            }
        }
        
        int sum = 0;    
        for(int val : marks) sum += val;
        
        double newAvg = ((sum - swaps)*(1.0) / n);
        
        return newAvg >= avg ? 1 : 0;
    }
}