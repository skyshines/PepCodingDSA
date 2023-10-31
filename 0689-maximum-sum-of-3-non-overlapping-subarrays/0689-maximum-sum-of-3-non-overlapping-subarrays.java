class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n = nums.length;
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];
        int[] psa = new int[n];
        
        int sum = 0;
        for(int i = 0; i < n; i++){
            if(i < k){
                sum += nums[i];
                dp1[i] = sum;
            }else{
                sum += nums[i] - nums[i - k];
                dp1[i] = Math.max(dp1[i - 1], sum);
            }
        }
        
        sum = 0;
        
        for(int i = n - 1; i >= 0; i--){
            if(i >= n - k){
                sum += nums[i];
                dp2[i] = sum;
            }else{
                sum += nums[i] - nums[i + k];
                dp2[i] = Math.max(dp2[i + 1], sum);
            }
        }
        
        for(int i = 0; i < n; i++){
            if(i == 0){
                psa[0] = nums[0];
            }else{
                psa[i] = psa[i - 1] + nums[i];
            }
        }
        
        
        int maxsum = 0;
        int simsa = 0;
        int silsa = 0;
        int sirsa = -1;
        
        for(int i = k; i <= n - 2 * k; i++){
            if(dp1[i - 1] + psa[i + k - 1] - psa[i - 1] + dp2[i + k] > maxsum){
                maxsum = dp1[i - 1] + psa[i + k - 1] - psa[i - 1] + dp2[i + k];
                simsa = i;
            }
        }
        
        int mslsa = dp1[simsa - 1];
        
        for(int i = 0; i <= simsa - k; i++){
            if(psa[i + k - 1] - (i == 0 ? 0 : psa[i - 1])  == mslsa){
                silsa = i;
                break;
            }
        }
        
        int msrsa = dp2[simsa + k];
        
        
        for(int i = simsa + k; i <= n - k; i++){
            if(psa[i + k - 1] - psa[i - 1] == msrsa){
                sirsa = i;
                break;
            }
        }
        
        return new int[]{silsa,simsa,sirsa};
    }
}