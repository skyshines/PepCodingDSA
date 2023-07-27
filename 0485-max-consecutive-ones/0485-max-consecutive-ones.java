class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int l = -1;
        int h = 0;
        int ans = 0;
        
        while(h < nums.length){
            if(nums[h] == 0){
                if(h - l - 1 > ans) ans = h - l - 1;
                
                l = h;
            }
            
            h++;
        }
        
        if(h - l - 1 > ans) ans = h - l - 1;
        
        return ans;
    }
}