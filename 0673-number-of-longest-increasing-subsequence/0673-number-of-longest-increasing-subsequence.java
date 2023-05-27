class Solution {
    public int findNumberOfLIS(int[] nums) {
        int[][] dp = new int[2][nums.length];
        
        int omax = 1;
        int omaxNum = 1;
        
        dp[0][0] = 1;
        dp[1][0] = 1;
        
        for(int i = 1; i < nums.length; i++){
            int max = 0;
            int maxNum = 1;
            
            for(int j = 0; j < i; j++){
                if(nums[j] < nums[i]){
                    if(dp[0][j] > max){
                        max = dp[0][j];
                        maxNum = dp[1][j];
                    }else if(dp[0][j] == max){
                        maxNum += dp[1][j];
                    }
                }
            }
            
            dp[0][i] = max + 1;
            dp[1][i] = maxNum;
            
            if(omax < max + 1){
                omax = max + 1;
                omaxNum = maxNum;
            }else if(omax == max + 1){
                omaxNum += maxNum;
            } 
        }
        
        return omaxNum;
    }
}