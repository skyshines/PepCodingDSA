public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int rev = 0;
        boolean flag = false;
        
        for(int i = 31; i >= 0; i--){
            int mask = 1 << i;
            
            if((n & mask) == 0){
               
            }else{
                 rev = ( rev | (1 << (31 - i)));
            }
        }
        
        return rev;
    }
}