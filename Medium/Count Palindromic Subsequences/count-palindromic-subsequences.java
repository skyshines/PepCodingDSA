//{ Driver Code Starts
import java.util.*;
class GFG
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		while(t>0)
		{
			String str = sc.nextLine();
			//System.out.println(str.length());
			Solution ob  = new Solution();
			System.out.println(ob.countPS(str));
		t--;
		}
	}
}
// } Driver Code Ends


/*You are required to complete below method */

class Solution
{
    long countPS(String s)
    {
        // Your code here
        long[][] dp = new long[s.length()][s.length()];
        long mod = (long)1e9 + 7;
        
        for(int gap = 0; gap < s.length(); gap++){
            for(int i = 0, j = gap; j < dp[0].length; i++, j++){
                char startChar = s.charAt(i); 
                char endChar = s.charAt(j);
                
                if(gap == 0){
                    dp[i][j] = 1;
                }else if(gap == 1){
                    if(startChar == endChar){
                        dp[i][j] = 3;
                    }else{
                        dp[i][j] = 2;
                    }
                }else{
                    if(startChar == endChar){
                        dp[i][j] = dp[i + 1][j] + dp[i][j - 1] + 1;
                    }else{
                        dp[i][j] = dp[i + 1][j] + dp[i][j - 1] - dp[i + 1][j - 1];
                    }
                }
                
                dp[i][j] = (dp[i][j] + mod) % mod;
            }
        }
        
        return dp[0][s.length() - 1];
    }
}