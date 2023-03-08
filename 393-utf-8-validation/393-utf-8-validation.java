class Solution {
    public boolean validUtf8(int[] data) {
        int rbtc = 0;
        
        for(int val : data){
            if(rbtc == 0){
                if((val >> 7) == 0b0){
                    rbtc = 0;
                }else if((val >> 5) == 0b110){
                    rbtc = 1;
                }else if((val >> 4) == 0b1110){
                    rbtc = 2;
                }else if((val >> 3) == 0b11110){
                    rbtc = 3;
                }else{
                    return false;
                }               
            }else{
                if((val >> 6) == 0b10){
                    rbtc--;
                }else{
                    return false;
                }
            }
        }
        
        return rbtc == 0;
        
    }
}