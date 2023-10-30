//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            
            String s = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.maxSubstring(s));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    int maxSubstring(String S) {
        // code here
        int ans = -1;
        int max = 0;
        
        for(char ch : S.toCharArray()){
            int val = ch == '1' ? -1 : 1;
            
            if(max > 0){
                max += val;
            }else{
                max = val;
            }
            
            if(max > ans) ans = max; 
        }
        
        return ans;
    }
}