class Solution {
    public int majorityElement(int[] nums) {
        int val = 0;
        int count = 0;
        
        for(int num : nums){
            if(count == 0){
                count = 1;
                val = num;
            }else{
                if(num == val) count++;
                else{
                    count--;
                }
            }
        }
        
        return val;
    }
}