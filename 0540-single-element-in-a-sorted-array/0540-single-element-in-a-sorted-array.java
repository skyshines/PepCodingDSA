class Solution {
    public int singleNonDuplicate(int[] nums) {
        if(nums.length < 3) return nums[0];
        
        int lo = 0;
        int hi = nums.length - 1;
        
        while(hi - lo + 1 > 3){
            int mid = (hi + lo) / 2;

            if((mid - lo) % 2 == 0){
                if(nums[mid] == nums[mid - 1]){
                    hi = mid;
                }else if(nums[mid] == nums[mid + 1]){
                    lo = mid;
                }else{
                    return nums[mid];
                }            
            }else{
                if(nums[mid] == nums[mid - 1]){
                    lo = mid + 1;
                }else{
                    hi = mid - 1;
                }
            }       
        }
        
        int mid = lo + (hi - lo) / 2;
            
        if(nums[mid] == nums[mid - 1]){
            return nums[mid + 1];
        }else{
            return nums[mid - 1];
        }
    }
}