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
    
    
    public int fibTabulation(int n){
        if(n == 0 || n == 1){
            return n;
        }
        
        int[] dp = new int[n + 1];
        
        dp[0] = 0;
        dp[1] = 1;
        
        for(int i = 2; i <= n; i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        
        return dp[n];
    }
    
    public int fibImp(int n){
        if(n == 0 || n == 1){
            return n;
        }
        
        int a = 1;
        int b = 0;
        
        int i = 2;
        
        while(i++ <= n){
            int na = a + b;
            int nb = a;
            
            a = na;
            b = nb;
        }
        
        return a;
    }
    
    public int fib(int n) {
       //return fibRecurrsive(n);
       //return fibMemoization(n, new int[n + 1]);
        //return fibTabulation(n);
        return fibImp(n);
        
    }
}