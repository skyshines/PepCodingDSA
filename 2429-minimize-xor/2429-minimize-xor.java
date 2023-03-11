class Solution {
    public int minimizeXor(int num1, int num2) {
        int ans = 0;
        
        for(int i = 31; i >= 0; i--){
            int mask = (1 << i);
            
            if((num1 & mask) == 0){
                
            }else{
                if(num2 > 0){
                    ans |= mask;
                    num2 = num2 - (num2 & (-num2));
                }else{
                    return ans;
                }
            }
        }
        
        for(int i = 0; i < 32; i++){
            int mask = (1 << i);
            
            if((num1 & mask) == 0){
                if(num2 > 0){
                    ans |= mask;
                    num2 = num2 - (num2 & (-num2));
                }else{
                    return ans;
                }
            }
        }
        
        return ans;
    }
}