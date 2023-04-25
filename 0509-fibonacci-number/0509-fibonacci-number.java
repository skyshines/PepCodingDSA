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
    public int fib(int n) {
       return fibRecurrsive(n);
    }
}