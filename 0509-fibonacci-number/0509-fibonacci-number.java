class Solution {
    public int fibRecurrsive(int n) {
       if(n == 0 || n == 1){
           return n;
       }
        
        int fibnm1 = fibRecurrsive(n - 1);
        int fibnm2 = fibRecurrsive(n - 2);
        int fibn = fibnm1 + fibnm2;
        return fibn; 
    }
    
    public int fibMemoization(int n, int[] dp) {
       if(n == 0 || n == 1){
           return n;
       }
        
       if(dp[n] != 0){
           return dp[n];
       } 
        
        int fibnm1 = fibMemoization(n - 1, dp);
        int fibnm2 = fibMemoization(n - 2, dp);
        int fibn = fibnm1 + fibnm2;
        
        dp[n] = fibn;
        
        return fibn; 
    }
    
    
    
    public int fib(int n) {
       //return fibRecurrsive(n);
       return fibMemoization(n, new int[n + 1]);
        
    }
}