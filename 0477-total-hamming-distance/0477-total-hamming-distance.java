class Solution {
    public int totalHammingDistance(int[] nums) {
        long ans = 0;
        
        for(int i = 0; i < 32; i++){
            long countOn = 0;
            long countOff = 0;
            
            for(int num : nums){
                if((num & (1 << i)) == 0){
                    countOff++;
                }else{
                    countOn++;
                }
            }
            
            ans += (countOn * countOff);
        }
        
        return (int)ans;
    }
}