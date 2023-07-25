class Solution {
    public int jump(int[] nums) {
        Integer[] dp = new Integer[nums.length];
        dp[0] = 0;
        
        for(int i = 0; i < nums.length; i++){
            if(true){
                for(int j = 1; j <= nums[i] && i + j < nums.length; j++){
                    if(dp[i + j] == null){
                        dp[i + j] = dp[i] + 1;
                    }else{
                        dp[i + j] = Math.min(dp[i + j], dp[i] + 1);
                    }
                }
            }
        }
        
        return dp[nums.length - 1];
    }
}