//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String str = br.readLine().trim();
            Solution ob = new Solution();
            int ans = ob.LongestRepeatingSubsequence(str);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int LongestRepeatingSubsequence(String str)
    {
        int[][] dp = new int[str.length() + 1][str.length() + 1];
        
        for(int i = str.length() - 1; i >= 0; i--){
            for(int j = str.length() - 1; j >= 0; j--){
                char ch1 = str.charAt(i);
                char ch2 = str.charAt(j);
                
                if(ch1 == ch2 && i != j){
                    dp[i][j] = dp[i + 1][j + 1] + 1;
                }else{
                    if(dp[i + 1][j] > dp[i][j + 1]){
                        dp[i][j] = dp[i + 1][j];
                    }else{
                        dp[i][j] = dp[i][j + 1];
                    }
                }
            }
        }
        
        return dp[0][0];
    }
}