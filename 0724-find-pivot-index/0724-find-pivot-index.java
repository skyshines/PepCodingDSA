class Solution {
    public int pivotIndex(int[] nums) {
        int lsum = 0;
        int rsum = 0;
        
        for(int val : nums) rsum += val;
        
        for(int i = 0; i < nums.length; i++){
            rsum -= nums[i];
            
            if(lsum == rsum) return i;
            
            lsum += nums[i];
        }
        
        return -1;
     }
}