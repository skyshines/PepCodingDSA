class Solution {
    public int singleNumber(int[] nums) {
        int tn = ~(0);
        int tnp1 = 0;
        int tnp2 = 0;
        
        for(int num : nums){
            int cwtn = (tn & num);
            int cwtnp1 = (tnp1 & num);
            int cwtnp2 = (tnp2 & num);
            
            tn = (tn & (~cwtn));
            tnp1 = (tnp1 | cwtn);
            
            tnp1 = (tnp1 & ~(cwtnp1));
            tnp2 = (tnp2 | (cwtnp1));
            
            tnp2 = (tnp2 & ~cwtnp2);
            tn = (tn | cwtnp2);
        }
        
        return tnp1;
    }
}