class Solution {
    public int missingNumber(int[] nums) {
        int i = 0;
        int x = 0;
        for(int val : nums){
            x = (x ^ val);
            x = (x ^ i++);
        }
        return x ^ i;
    }
}