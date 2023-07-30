class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int start = 0;
        int min = Integer.MAX_VALUE;
        
        for(int i = nums.length - 1; i >= 0; i--){
            if(nums[i] <= min){
                min = nums[i];
            }else{
                start = i;
            }
        }
        
        int end = -1;
        int max = Integer.MIN_VALUE;
        
        for(int i = 0 ; i < nums.length; i++){
            if(nums[i] >= max){
                max = nums[i];
            }else{
                end = i;
            }
        }
        
        return end - start + 1;
        
    }
}