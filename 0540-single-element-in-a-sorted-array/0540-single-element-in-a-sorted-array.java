class Solution {
    public int helper(int[] nums,int lo,int hi){
        if(hi - lo + 1 == 3){
            int mid = lo + (hi - lo) / 2;
            
            if(nums[mid] == nums[mid - 1]){
                return nums[mid + 1];
            }else{
                return nums[mid - 1];
            }
        }
        
        int mid = (hi + lo) / 2;
        
        if((mid - lo) % 2 == 0){
            if(nums[mid] == nums[mid - 1]){
                return helper(nums,0,mid);
            }else if(nums[mid] == nums[mid + 1]){
                return helper(nums,mid,hi);
            }else{
                return nums[mid];
            }            
        }else{
            if(nums[mid] == nums[mid - 1]){
                return helper(nums,mid + 1,hi);
            }else{
                return helper(nums,lo,mid - 1);
            }
        }
        

    }
    public int singleNonDuplicate(int[] nums) {
        if(nums.length < 3) return nums[0];
        
        return helper(nums,0,nums.length - 1);
    }
}