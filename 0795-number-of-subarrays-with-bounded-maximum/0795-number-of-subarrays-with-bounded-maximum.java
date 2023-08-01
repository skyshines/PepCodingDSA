class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int si = 0;
        int ei = 0;
        
        int prevCount = 0;
        int count = 0;
        
        while(ei < nums.length){
            if(nums[ei] < left){
                count += prevCount;
                
            }else if(nums[ei] >= left && nums[ei] <= right){
                prevCount = ei - si + 1;
                count += prevCount;
                
            }else{
                si = ei + 1;
                prevCount = 0;
            }
            
            ei++;
        }
        
        return count;
    }
}