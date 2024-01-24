class Solution {
    public long maxAlternatingSum(int[] nums) {
        long[][] dp = new long[nums.length][2];
        return memoization(0,nums,0,dp);
    }
    
    public long memoization(int idx,int[] nums,int curr,long[][] dp){
        if(idx >= nums.length) return 0;
        
        if(dp[idx][curr] != 0) return dp[idx][curr];
        
        long ansInc = 0;
        
        //element included
        if(curr % 2 == 0){
            ansInc = memoization(idx + 1,nums,(curr + 1) % 2,dp) + nums[idx];
        }else{
            ansInc = memoization(idx + 1,nums,(curr + 1) % 2,dp)- nums[idx];
        }
        
        //element excluded
        
        long ansExc = memoization(idx + 1,nums,curr,dp);
        
        dp[idx][curr] = Math.max(ansInc,ansExc);
        
        return dp[idx][curr];
    }
}