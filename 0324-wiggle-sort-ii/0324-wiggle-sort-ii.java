class Solution {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        
        int i = 1;
        int j = nums.length - 1;
        
        int[] ans = new int[nums.length];
        
        while(i < nums.length){
            ans[i] = nums[j];
            i += 2;
            j--;
        }
        
        i = 0;
        
        while(i < nums.length){
            ans[i] = nums[j];
            i += 2;
            j--;
        }
        
        for(i = 0; i < nums.length; i++){
            nums[i] = ans[i];
        }
        
    }
}