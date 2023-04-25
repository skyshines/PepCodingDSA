class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        long[] dp = new long[n + 1];
        dp[n] = 0;
        
        for(int i = n - 1;  i >= 0; i--){
            dp[i] = cost[i];
            long min = (long)1e10;
            
            for(int j = 1; j <= 2 && j + i <= n; j++){
                if(min > dp[i + j]) min = dp[i + j]; 
            }
            
            dp[i] +=  min;
        }
        
        return (int)(dp[0] > dp[1] ? dp[1] : dp[0]);
    }
}