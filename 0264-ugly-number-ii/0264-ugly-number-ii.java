class Solution {
    public int nthUglyNumber(int n) {
       int p2 = 0;int p3 = 0; int p5 = 0;
       int[] dp = new int[n];
        dp[0] = 1;
       for(int i = 1; i < n; i++){
          int fac2 = 2*dp[p2];
          int fac3 = 3*dp[p3];
           int fac5 = 5*dp[p5];
           
           dp[i] = (int)Math.min(fac2,(int)Math.min(fac3,fac5));
           
           if(dp[i] == fac2){
               p2++;
           }
           
           if(dp[i] == fac3){
               p3++;
           }
           
           if(dp[i] == fac5){
               p5++;
           }
       }
        
        return dp[n - 1];
    }
}