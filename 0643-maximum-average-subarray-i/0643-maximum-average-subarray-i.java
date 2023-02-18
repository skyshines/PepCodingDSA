class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        for(int i = 0; i < k; i++) sum += nums[i];
        int max = sum;
        
        for(int i = 1; i <= nums.length - k; i++){
            sum += nums[i + k - 1] - nums[i - 1];
            max = (int)Math.max(sum,max);
        }
        
        return (1.0)*max / k;
    }
}