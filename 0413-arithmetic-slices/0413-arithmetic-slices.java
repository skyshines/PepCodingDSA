class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        if(nums.length < 3){
            return 0;
        }
        
        //int[] dp = new int[nums.length];
        int sum = 0;
        int dp1 = 0; int dp2 = 0;
        for(int i = 2; i < nums.length; i++){
            if(nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]){
                dp2 = dp1 + 1;
                sum += dp2;
            }else{
                dp2 = 0;
            }
            
            dp1 = dp2;
        }
        
        return sum;
    }
}