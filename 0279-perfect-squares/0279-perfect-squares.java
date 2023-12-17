class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        
        for(int i = 1; i <= n; i++){
            int min = Integer.MAX_VALUE;
            
            for(int j = 1 * 1; j * j <= i; j++){
                if(dp[i - j * j] < min) min = dp[i - j * j];
            }
            
            dp[i] = min + 1;
        }
        
        return dp[n];
    }
}