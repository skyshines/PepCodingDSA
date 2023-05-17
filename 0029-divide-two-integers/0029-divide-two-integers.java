class Solution {
    public int divide(int dividend, int divisor) {
        if(dividend == (1 << 31) && divisor == -1){
            return (1 << 31) - 1;//int max value
        }
        
        // if(dividend == (1 << 31) && divisor == 1){
        //     return (1 << 31);
        // }
        
//         if(dividend == (1 << 31) - 1 && divisor == -1){
//             return -((1 << 31) - 1);//int max value)
//         }
        
//         if(dividend == (1 << 31) - 1 && divisor == 1){
//             return ((1 << 31) - 1);//int max value)
//         }
        
        boolean flag = false;
        
        if((dividend >= 0 && divisor >= 0) || (dividend < 0 && divisor < 0)){
             flag = true;
        }
        
        long a = dividend * 1L;
        long b = divisor * 1L;
        
        if(a < 0) a *= -1;
        if(b < 0) b *= -1;
        
        int ans = 0;
        
        while(a >= b){
            int q = 0;
            
            while(a >= (b << (q + 1))){
                q++;
            }
            
            ans += (1 << q);
            a -= (b << q);
        }
        
        if(flag == true) return ans;
        else return -ans;
    }
}