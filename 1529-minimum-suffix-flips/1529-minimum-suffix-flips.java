class Solution {
    public int minFlips(String target) {
        int bit = 0;
        int flips = 0;
        
        for(char ch : target.toCharArray()){
            int x = ch - '0';
            if(x == bit){
                
            }else{
                bit = (bit ^ 1);
                flips++;
            }
            
        }
        
        return flips;
    }
}