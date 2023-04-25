class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        long b = cost[n - 1];
        long a = cost[n - 2];
        long currVal = 0;
        
        for(int i = n - 3;  i >= 0; i--){
            currVal = cost[i];
            currVal += a > b ? b : a;
            
            b = a;
            a = currVal;
        }
        
        return (int)(a > b ? b : a);
    }
}