class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        if(nums.length < 3){
            return 0;
        }
        
        int[] diff = new int[nums.length - 1];
        
        for(int i = 0; i < nums.length - 1; i++){
            diff[i] = nums[i + 1] - nums[i];
            System.out.print(diff[i] + " ");
        }
        System.out.println();
        
        int n = 2; int sum = 0;
        
        for(int i = 1; i < diff.length; i++){
            if(diff[i] == diff[i - 1]){
                
                n++;
                
                System.out.println(n);
            }else{
                sum += (n - 2)*(n - 1)/2;
                n = 2;
            }
        }

        sum += (n - 2)*(n - 1)/2;
        
        return sum;
    }
}