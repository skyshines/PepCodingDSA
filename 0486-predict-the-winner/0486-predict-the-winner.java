class Solution {    
    public boolean predictTheWinner(int[] nums) {
        if(nums.length == 1 || nums.length % 2 == 0) return true;
        int[] arr = nums;
        int n = arr.length;
        int[][] dp = new int[n][n];
        
        for(int g = 0; g < dp.length; g++){
            for(int i = 0, j = g; j < dp.length; j++, i++){
                if(g == 0){
                    dp[i][j] = arr[i];
                }else if(g == 1){
                    dp[i][j] = Math.max(arr[i], arr[j]);
                }else{
                    int val1 = arr[i] + Math.min(dp[i + 2][j],dp[i + 1][j - 1]);
                    int val2 = arr[j] + Math.min(dp[i + 1][j - 1],dp[i][j - 2]);
                    int val = Math.max(val1, val2);
                    dp[i][j] = val;
                }
            }
        }
        
        int sum =0;
        for(int val : arr) sum += val;
        
        //part 1
        
        
        int ans1 = dp[1][n - 1];
        if(sum >= 2 * ans1) return true;
        
        int ans2 = dp[0][n - 2];
        return (sum >= 2 * ans2);
        
    }
}