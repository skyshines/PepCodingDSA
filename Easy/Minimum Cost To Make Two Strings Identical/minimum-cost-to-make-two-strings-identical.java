//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String X = sc.next();
                    String Y = sc.next();
                    int costX = sc.nextInt();
                    int costY = sc.nextInt();
                    
                   
                    Solution ob = new Solution();
                    System.out.println(ob.findMinCost(X,Y,costX,costY));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
	public int findMinCost(String X, String Y, int costX, int costY)
	{
		// Your code goes here
	    //longest Common Subsequence
	    
	    int[][] dp = new int[X.length() + 1][Y.length() + 1];
	    
	    for(int i = dp.length - 2; i >= 0; i--){
	        for(int j = dp[0].length - 2; j >= 0; j--){
	            if(X.charAt(i) == Y.charAt(j)){
	                dp[i][j] = dp[i + 1][j + 1] + 1;
	            }else{
	                dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
	            }
	        }
	    }
	    
	    int lcs = dp[0][0];
	    
	    int cx = (X.length() - lcs) * costX;
	    int cy = (Y.length() - lcs) * costY;
	    return cx + cy;
	}
}
