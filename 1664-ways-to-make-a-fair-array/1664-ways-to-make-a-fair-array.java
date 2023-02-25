class Solution {
    public int waysToMakeFair(int[] nums) {
        int n = nums.length;
        int[] evenprefixsum = new int[n];
        int[] oddprefixsum = new int[n];
        
        int evensum = 0;
        int oddsum = 0;
        
        for(int i = 0; i < n; i++){
            if(i % 2 == 0) evensum += nums[i];
            else{
                oddsum += nums[i];
            }
            
            evenprefixsum[i] = evensum;
            oddprefixsum[i] = oddsum;
        }
        
        int ans = 0;
        
        for(int i = 0; i < n; i++){
            int es = 0,os = 0;
            if(i == 0){
                es = oddprefixsum[n - 1] - oddprefixsum[i];
                os = evenprefixsum[n - 1] - evenprefixsum[i];
            }else{
                es = evenprefixsum[i - 1] + (oddprefixsum[n - 1] - oddprefixsum[i]);
                os = oddprefixsum[i - 1] + (evenprefixsum[n - 1] - evenprefixsum[i]);
            }
            
            if(es == os){
                ans++;
            }
        }
        
        return ans;
    }
}