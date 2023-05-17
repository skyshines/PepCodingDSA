class Solution {
    public int singleNumber(int[] nums) {
        int one = 0;
        int two = 0;
        
        for(int num : nums){
            int ntwo = (num & one) + (~num & two);
            int none = (~num & one) + (num & ~one & ~two);
            
            one = none;
            two = ntwo;
        }
        
        return one;
    }
}