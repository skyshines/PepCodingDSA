class Solution {
    public int totalHammingDistance(int[] nums) {
        int ans = 0;
        
        for(int i = 0; i < 32; i++){
            int countOn = 0;
            
            for(int num : nums){
                if((num & (1 << i)) != 0){
                    countOn++;
                }
            }
            
            ans += (countOn * (nums.length - countOn));
        }
        
        return ans;
    }
}