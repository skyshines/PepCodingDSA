class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int sp = 0;
        int ep = 0;
        int sum = 0;
        int minLength = 100001;
        
        for(; ep < nums.length; ep++){
            sum += nums[ep];
            
            while(sp <= ep){
                if(sum < target){
                    break;
                }else{
                    int len = ep - sp + 1;
                    
                    if(len < minLength){
                        minLength = len;
                    }
                    
                    sum -= nums[sp++];
                }
            }
        }
        
        return minLength == 100001 ? 0 : minLength;
    }
}