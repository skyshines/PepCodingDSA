class Solution {
    public boolean isPossible(int[] arr, long target, int k){
        int students = 1;
        long sum = 0;
        
        for(int val : arr){
            if(sum + val > target){
                students++;
                sum = 1L * val;
            }else{
                sum += val;
            }
        }
        
        return students <= k;
    }
    public int splitArray(int[] arr, int M) {
        int N = arr.length;
        long sum = 0L;
        int max = 0;
        
        for(int val : arr){
            sum += val;
            if(val > max) max = val;
        }
        
        if(M == 1) return (int)sum;
        if(M == N) return max;
        if(M > N) return -1;
        
        long lo = 1L * max;
        long hi = sum;
        
        long ans = 0;
        
        while(lo <= hi){
            long mid = lo + (hi - lo) / 2;
            
            if(isPossible(arr,mid,M) == true){
                ans = mid;
                hi = mid - 1;
            }else{
                lo = mid + 1;
            }
        }
        
        return (int)ans;
    }
}