class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int count1 = 0; int count2 = 0; int count3 = 0; int count4 = 0;
        int num1 = tops[0];
        int num2 = bottoms[0];
        
        for(int i = 0; i < tops.length; i++){
            if(count1 != Integer.MAX_VALUE){
                if(tops[i] == num1){
                    
                }else if(bottoms[i] == num1){
                    count1++;
                }else{
                    count1 = Integer.MAX_VALUE;
                }
            }
            
            if(count2 != Integer.MAX_VALUE){
                if(tops[i] == num2){
                    
                }else if(bottoms[i] == num2){
                    count2++;
                }else{
                    count2 = Integer.MAX_VALUE;
                }
            }
            
            if(count3 != Integer.MAX_VALUE){
                if(bottoms[i] == num1){
                    
                }else if(tops[i] == num1){
                    count3++;
                }else{
                    count3 = Integer.MAX_VALUE;
                }
            }
            
            if(count4 != Integer.MAX_VALUE){
                if(bottoms[i] == num2){
                    
                }else if(tops[i] == num2){
                    count4++;
                }else{
                    count4 = Integer.MAX_VALUE;
                }
            }
        }
        
        int m1 = Math.min(count1, count2);
        int m2 = Math.min(count3, count4);
        int m3 = Math.min(m1, m2);
        
        if(m3 == Integer.MAX_VALUE){
            return -1;
        }else{
            return m3;
        }
        
    }
}