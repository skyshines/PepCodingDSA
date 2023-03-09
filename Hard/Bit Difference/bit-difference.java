//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String arr[] = in.readLine().trim().split("\\s+");
            long A[] = new long[N];
            for(int i = 0; i < N; i++)
                A[i] = Long.parseLong(arr[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.countBits(N, A));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int countBits(int N, long A[])
    {
        long res = 0;
        
        for(int i = 0; i < 32; i++){
            long countOn = 0;
            
            for(long val : A){
                if((val & (1 << i)) != 0){
                    countOn++;
                }
            }
            
            long countOff = N - countOn;
            
            res += (countOn * countOff * 2);
        }
        
        return (int)(res % ((long)Math.pow(10,9) + 7));
    }
}