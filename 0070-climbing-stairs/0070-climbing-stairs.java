class Solution {
    public int climbStairsMemoization(int n, int[] dp) {
        if(n == 0){
            return 1;
        }else if(n < 0){
            return 0;
        }
        
        if(dp[n] != 0){
            return dp[n];
        }
        
        int p1 = climbStairsMemoization(n - 1, dp);
        int p2 = climbStairsMemoization(n - 2, dp);
        
        dp[n] = p1 + p2;
        
        return dp[n];
    }
    
    public int climbStairs(int n){
        return climbStairsMemoization(n, new int[n + 1]);
    }
}