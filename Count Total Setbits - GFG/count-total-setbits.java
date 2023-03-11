//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            System.out.println(ob.countBits(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int countBits(int N){
         if(N == 0){
             return N;
         }
        
        int x = maxPowerOfTwo(N);
        int btill2x = (1 << (x - 1)) * x;
        int b2xtoN = N - (1 << x) + 1;
        
        return btill2x + b2xtoN + countBits(N - (1 << x));
    }
    
    static int maxPowerOfTwo(int n){
        int p = 0;
        
        while((1 << p) <= n){
            p++;
        }
        
        return p - 1;
    }
}