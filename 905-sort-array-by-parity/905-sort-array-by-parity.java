class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        //i plus i k left sare even bande honge
        //j plus j k right sare odd bande honge
        while(i < j){
            if(nums[i] % 2 == 0){
                i++;
            }else{
                if(nums[j] % 2 == 0){
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                    i++;
                }
                j--;
            }
        }
        
        return nums;
    }
}