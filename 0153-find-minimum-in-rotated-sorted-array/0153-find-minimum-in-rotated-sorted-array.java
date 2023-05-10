class Solution {
    public int findMin(int[] nums) {       
        int lo = 0;
        int hi = nums.length - 1;
        int mid = 0;
        
        while(lo <= hi){
            mid = lo + (hi - lo) / 2;
            
            if(mid >= 1 && nums[mid - 1] > nums[mid]){
                return nums[mid];
            }else if(mid < nums.length - 1 && nums[mid] > nums[mid + 1]){
                return nums[mid + 1];
            }else if(nums[mid] <= nums[hi]){
                hi = mid - 1;
            }else{
                lo = mid + 1;
            }
        }
        
        return nums[mid];
    }
}