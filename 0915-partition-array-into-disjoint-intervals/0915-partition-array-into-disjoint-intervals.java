class Solution {
    public int partitionDisjoint(int[] nums) {
        if(nums.length < 2) return 0;
        
        int[] rmin = new int[nums.length];
        
        int min = 1000000;
        
        for(int i = rmin.length - 1; i >= 0; i--){
            if(nums[i] < min) min = nums[i];
            
            rmin[i] = min;
        }
        
        int leftmax = nums[0];
        
        for(int i = 0; i <= nums.length - 2; i++){
            if(leftmax <= rmin[i + 1]){
                return i + 1;
            }
            
            if(leftmax < nums[i]) leftmax = nums[i];
        }
        
        return 1;
    }
}