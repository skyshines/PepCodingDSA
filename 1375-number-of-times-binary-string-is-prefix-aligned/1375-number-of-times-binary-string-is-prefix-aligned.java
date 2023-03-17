class Solution {
    public int numTimesAllBlue(int[] flips) {
        int count = 0;
        
        int sumi = 0;
        int sumflips = 0;
        
        for(int i = 1; i <= flips.length; i++){
            sumi += i;
            sumflips += flips[i - 1];
            
            if(sumflips == sumi) count++;
        }
        
        return count;
    }
}