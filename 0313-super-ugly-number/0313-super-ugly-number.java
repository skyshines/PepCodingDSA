class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
       int[] dp = new int[n];
        dp[0] = 1;
        
        int[] ptrs = new int[primes.length];
        // all pointers already pointing to 1 or dp[0]
        for(int i = 1; i < n; i++){
            
            long min = Integer.MAX_VALUE;
            for(int j = 0; j < primes.length; j++){
                if((1L)*primes[j] * dp[ptrs[j]] < min){
                    min =(1L)* primes[j] * dp[ptrs[j]];
                }
            }
            dp[i] = (int)min;
            
            for(int j = 0; j < primes.length; j++){
                if((1L)*primes[j] * dp[ptrs[j]] == min){
                    ptrs[j]++;
                }
            }
        }
        
        return dp[n - 1];
    }
}