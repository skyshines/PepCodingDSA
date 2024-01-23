class Solution {
    public int deleteAndEarn(int[] nums) {
        int[] count = new int[10001];
        int inc = 0;
        int exc = 0;
        
        for(int num : nums){
            count[num]++;
        }
        
        for(int i = 1; i < count.length; i++){
            int ninc = exc + count[i] * i;
            int nexc = Math.max(inc, exc);
            
            inc = ninc;
            exc = nexc;
        }
        
        return Math.max(inc, exc);
    }
}