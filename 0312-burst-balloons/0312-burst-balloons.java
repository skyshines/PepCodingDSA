class Solution {
    public int maxCoins(int[] nums) {
        int[][] dp = new int[nums.length][nums.length];
        
        for(int gap = 0; gap < dp.length; gap++){
            for(int i = 0, j = gap; j < dp.length; i++, j++){
                int max = -1;
                for(int k = i; k <= j; k++){
                    int left = k == i ? 0 : dp[i][k - 1];
                    int right  = k == j ? 0 : dp[k + 1][j];
                    int val = (i == 0 ? 1 : nums[i - 1]) * nums[k] *(j == nums.length - 1 ? 1 : nums[j + 1]);
                    int total = left + right + val;
                    
                    if(total > max) max = total;
                }
                
                dp[i][j] = max;
            }
        }
        
        return dp[0][dp[0].length - 1];
    }
}