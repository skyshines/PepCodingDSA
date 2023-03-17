class Solution {
    public int minFlips(String target) {
        char bit = '0';
        int flips = 0;
        
        for(char ch : target.toCharArray()){
            if(ch == bit){
                
            }else{
                flips++;
                if(bit == '0') bit = '1';
                else bit = '0';
            }
        }
        
        return flips;
    }
}