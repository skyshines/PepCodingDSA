class Solution {
    public int findMin(int[] nums) {
//         if(nums[0] <= nums[nums.length - 1]){
//             return nums[0];
//         }
        
        int lo = 0;
        int hi = nums.length - 1;
        
        while(lo <= hi){
            int mid = lo + (hi - lo) / 2;
            
            if(mid >= 1 && nums[mid - 1] > nums[mid]){
                return nums[mid];
            }else if(mid < nums.length - 1 && nums[mid] > nums[mid + 1]){
                return nums[mid + 1];
            }else if(nums[lo] <= nums[mid]){
                lo = mid + 1;
            }else{
                hi = mid - 1;
            }
        }
        
        return nums[0];
    }
}