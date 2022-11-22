class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        //i plus i k left sare even bande honge
        //j plus j k right sare odd bande honge
        /*i start hua left c and j right c
          agar i par even mila sahi hai we did i++
            agar odd mila phir j ko dekha
            agar j odd hai bahut badhiya we did j++ and if j is even we swapped them and incremented both
            we did this till i < j
            basically array has three parts even unsolved and odd part*/
        while(i < j){
            if(nums[i] % 2 == 0){
                i++;
            }else{
                if(nums[j] % 2 == 0){
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                    i++;
                    j--;
                }else if(nums[j] % 2 == 1){
                j--;
                }
            }
        }
        
        return nums;
    }
}
