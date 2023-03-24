class Solution {
    public int[] sortedSquares(int[] nums) {
        if(nums.length == 0) return nums;
        
        
        
        int i = 0;
        int j = nums.length - 1;
        int[] ans = new int[nums.length];
        int k = nums.length - 1;
        
        while(i <= j){
            int val1 = nums[i] < 0 ? -nums[i] : nums[i];
            int val2 = nums[j] < 0 ? -nums[j] : nums[j];
            
            if(val1 > val2){
                ans[k] = val1 * val1;
                k--;
                i++;
            }else{
                ans[k] = val2 * val2;
                k--;
                j--;
            }
        }
        
        return ans;
    }
}