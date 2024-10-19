class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int i = -1;
        int j = -1;
        int sum = 0;
        int ans = nums.length + 1;
        
        while(i < nums.length && j < nums.length){
            if(sum < target){
                i++;
                if(i < nums.length) sum += nums[i];
            }else if(sum >= target){
                j++;
                if(j < nums.length) sum -= nums[j];
            }
            
            if(sum >= target) ans = Math.min(ans, i - j);
        }
        
        return ans == nums.length + 1 ? 0 : ans;
    }
}