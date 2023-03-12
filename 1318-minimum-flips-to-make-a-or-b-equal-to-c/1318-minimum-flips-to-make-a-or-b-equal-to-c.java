class Solution {
    public int minFlips(int a, int b, int c) {
        int minFlips = 0;
        
        for(int i = 31; i >= 0; i--){
            int mask = (1 << i);
            
            if(((a & mask) | (b & mask)) != 0 & (c & mask) == 0){
                if(((a & mask) & (b & mask)) == 0){
                    minFlips++;
                }else{
                    minFlips += 2;
                }
            }else if(((a & mask) | (b & mask)) == 0 & (c & mask) != 0){
                minFlips++;
            }
        }
        
        return minFlips;
        
    }
}