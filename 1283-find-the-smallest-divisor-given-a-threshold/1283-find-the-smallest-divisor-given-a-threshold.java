class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int max = Integer.MIN_VALUE;
        
        for(int i = 0; i < nums.length; i++){
            max = (int)Math.max(max,nums[i]);
        }
        
        if(threshold == nums.length){
            return max;
        }
        
        int lo = 0; int hi = max; int div = Integer.MAX_VALUE;
        
        while(lo <= hi){
            int mid = lo + (hi - lo) / 2;
            
            if(checkInRange(nums,mid,threshold) == true){
                div = mid;
                hi = mid - 1;
            }else{
                lo = mid + 1;
            }
        }
        
        return div;
    }
    
    public boolean checkInRange(int[] arr,int div,int threshold){
        int sum = 0;
        
        for(int i = 0; i < arr.length; i++){
            sum += Math.ceil(arr[i]*1.0 / div);
        }
        
        return sum <= threshold;
    }
}