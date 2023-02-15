class Solution {
    public int helper(int n){
        int nm1 = 1;
        int nm2 = 0;
        int t = 0;
        for(int i = 1; i <= n; i++){
            t = nm1 + nm2;
            nm2 = nm1;
            nm1 = t;
        }
        return t;
    }
    public int climbStairs(int n) {
        return helper(n);
    }
}