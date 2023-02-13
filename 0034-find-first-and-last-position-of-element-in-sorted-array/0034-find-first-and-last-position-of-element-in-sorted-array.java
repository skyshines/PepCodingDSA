class Solution {
    public int[] searchRange(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        
        int fp = -1,lp = -1;
        
        while(lo <= hi){
            int mid = lo + (hi - lo) / 2;
            
            if(nums[mid] == target){
                fp = mid;
                hi = mid - 1;
            }else if(nums[mid] > target){
                hi = mid - 1;
            }else{
                lo = mid + 1;
            }
        }
        
        lo = 0;
        hi = nums.length - 1;
        
        while(lo <= hi){
            int mid = lo + (hi - lo) / 2;
            
            if(nums[mid] == target){
                lp = mid;
                lo = mid + 1;
            }else if(nums[mid] > target){
                hi = mid - 1;
            }else{
                lo = mid + 1;
            }
        }
        
        int[] arr = {fp,lp};
        
        return arr;
    }
}