class Solution {
    public int maxProduct(int[] nums) {
        int ans = -200000;
        int product = 1;
        
        //for left starting subarray
        for(int num : nums){
            product *= num;
            if(product > ans) ans = product;
            
            //if product = 0 start new subarray
            if(product == 0) product = 1;
        }
        
        //for right starting subarray
        product = 1;
        for(int i = nums.length - 1; i >= 0; i--){
            int num = nums[i];
             product *= num;
            if(product > ans) ans = product;
            
            //if product = 0 start new subarray
            if(product == 0) product = 1;
        }
        
        return ans;
    }
}