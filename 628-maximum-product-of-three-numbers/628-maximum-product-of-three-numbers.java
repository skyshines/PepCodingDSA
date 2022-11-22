class Solution {
    public int maximumProduct(int[] nums) {
       int min1 = Integer.MAX_VALUE;
       int min2 = Integer.MAX_VALUE;
        
       int max1 = Integer.MIN_VALUE; 
       int max2 = Integer.MIN_VALUE;
       int max3 = Integer.MIN_VALUE;
        int product1 = Integer.MIN_VALUE; int product2 = Integer.MIN_VALUE;
       //find all of them in one pass
        
        for(int val : nums){
            
            //for max
            if(val >= max1){ //equal to aayega since max2 max3 to update ho jaye
                            //par agar nhi lagyenge agli bar mai update ho jayega
                max3 = max2;
                max2 = max1;
                max1 = val;
            }else if(val >= max2){
                max3 = max2;
                max2 = val;
            }else if(val > max3){
                max3 = val;
            }
            
            //for min
            
            if(val <= min1){
                min2 = min1;
                min1 = val;
            }else if(val < min2){
                min2 = val;
            }
        }
        
        product2 = max1 * max2 * max3;
        if(min1 < 0 && min2 < 0){
            product1 = min1 * min2 * max1;
        }
        
        return (int)Math.max(product1,product2);
    }
}