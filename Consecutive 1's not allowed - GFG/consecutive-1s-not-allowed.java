//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());

            long ans = new Solution().countStrings(n);

            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    long countStrings(int n) {
        long[] dpZero = new long[n + 1];
        long[] dpOne = new long[n + 1];
        
        long mod =(long)1e9 + 7; 
        
        dpZero[1] = 1;
        dpOne[1] = 1;
        
        for(int i = 2; i <= n; i++){
            dpZero[i] = (dpZero[i - 1] + dpOne[i - 1]) % mod;
            dpOne[i] = dpZero[i - 1];
        }
        
        return ((dpZero[n] + dpOne[n])%mod);
    }
}