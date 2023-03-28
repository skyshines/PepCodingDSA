class Solution {
    public int rob(int[] nums) {
        //include and exclude technique
        int n = nums.length - 1;
        
        int include = nums[0];
        int exclude = 0;
        
        int ithinclude = 0;
        int ithexclude = 0;
        
        for(int i = 1; i < nums.length; i++){
            ithinclude = nums[i] + exclude;
            ithexclude = exclude > include ? exclude : include;
            
            include = ithinclude;
            exclude = ithexclude;
        }
        
        if(include > exclude) return include;
        else return exclude;
    }
}