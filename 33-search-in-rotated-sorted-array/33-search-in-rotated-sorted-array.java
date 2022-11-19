class Solution {
    public int search(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        
        while(lo <= hi){
            int mid = lo + ((hi - lo) / 2);
            
            if(nums[mid] == target){
                    return mid;
            }
            //first part means left and second part means right
            
            if(nums[mid] >= nums[lo]){
                //first part is sorted
                if(nums[mid] > target && nums[lo] <= target){
                    hi = mid - 1;
                }else{
                    lo = mid + 1;
                }
            }else if(nums[mid] <= nums[hi]){
                //second part of array is sorted
                if(nums[mid] < target && nums[hi] >= target){
                    lo = mid + 1;
                }else{
                    hi = mid - 1;
                }
            }
        }
        
        return -1;
    }
}