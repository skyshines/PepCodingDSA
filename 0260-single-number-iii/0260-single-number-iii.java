class Solution {
    public int[] singleNumber(int[] nums) {
        int x = 0;
        for(int val : nums) x = (x ^ val);
        
        int rsbm = x & (-x);
        
        System.out.println(x);
        
        int a = 0; int b = 0;
        
        for(int val : nums){
            if((val & rsbm) == 0){
                a = a ^ val;
            }else{
                b = b ^ val;
            }
        }
        
        int[] ans = {a,b};
        return ans;
    }
}