class Solution {
    public int firstMissingPositive(int[] nums) {
        boolean oneFound = false;
        
        //marking elements out of range
        for(int i = 0; i < nums.length; i++){
            
            if(nums[i] == 1) oneFound = true;
            
            if(nums[i] <= 0 || nums[i] > nums.length){
                nums[i] = 1;
            }
        }
        
        if(oneFound == false) return 1;
        
        //Mapping elements with index
        
        for(int i = 0; i < nums.length; i++){
            //purifying index
            int idx = (int)Math.abs(nums[i]) - 1;
            //marking elemt present by keeping negative value
            if(nums[idx] > 0) nums[idx] *= -1;
        }
        
        //Finding Missing Positive
        
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0){
                return i + 1;
            }
        }
            
        return nums.length + 1;    
    }
}