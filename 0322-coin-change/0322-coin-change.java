class Solution {
    public int coinChange(int[] coins, int amount) {
        Integer[] dp = new Integer[amount + 1];
        dp[0] = 0;
        
        for(int coin : coins){
            for(int j = coin; j <= amount; j++){
                if(dp[j] == null){
                    if(dp[j - coin] != null) dp[j] = dp[j - coin] + 1;
                }else{
                    if(dp[j - coin] != null && dp[j] > dp[j - coin] + 1){
                        dp[j] = dp[j - coin] + 1;
                    }
                }
            }
        }
        
        return dp[amount] == null ? -1 : dp[amount];
    }
}