class Solution {
    public long maxAlternatingSum(int[] nums) {
        long[][] dp = new long[nums.length][2];
        return tabulation(nums);
    }
    
    public long tabulation(int[] nums){
        long[] endEven = new long[nums.length]; //max sum of subsequence ending at even index
        long[] endOdd = new long[nums.length]; //max sum of subsequnce ending at odd index
        
        //base case
        endEven[0] = nums[0];
        endOdd[0] = 0;
        
        //include exclude technique
        
        for(int i = 1; i < nums.length; i++){
            endEven[i] = Math.max(endEven[i - 1], endOdd[i - 1] + nums[i]);
            endOdd[i] = Math.max(endOdd[i - 1], endEven[i - 1] - nums[i]);
        }
        
        return Math.max(endEven[nums.length - 1],endOdd[nums.length - 1]);
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