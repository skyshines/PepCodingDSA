class Solution {
    public int partitionDisjoint(int[] nums) {
        if(nums.length < 2) return 0;
        
        int[] leftmax = new int[nums.length - 1];
        
        int max = 0;
        
        for(int i = 0; i < leftmax.length; i++){
            if(nums[i] > max) max = nums[i];
            
            leftmax[i] = max;
        }
        
        int rmin = nums[nums.length - 1];
        int ans = 0;
        
        for(int i = leftmax.length - 1; i >= 0; i--){
            if(leftmax[i] <= rmin) ans = i + 1;
            
            if(nums[i] < rmin) rmin = nums[i];
        }
        
        return ans;
    }
}