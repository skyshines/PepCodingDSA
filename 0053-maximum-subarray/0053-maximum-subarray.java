class Solution {
    public int maxSubArray(int[] nums) {
        int currentsum = nums[0];
        int overallsum = nums[0];
        
        for(int i = 1; i < nums.length; i++){
            if(currentsum + nums[i] >= nums[i]){
                currentsum += nums[i];
            }else{
                currentsum = nums[i];
            }
            
            if(currentsum > overallsum){
                overallsum = currentsum;
            }
        }
        
        return overallsum;
    }
}