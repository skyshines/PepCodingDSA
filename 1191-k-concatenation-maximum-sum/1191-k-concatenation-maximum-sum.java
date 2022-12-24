class Solution {
    
    
    public long kadanes(int[] arr, int k){
        long csum = arr[0]; long osum = arr[0];
        
        for(int i = 1; i < arr.length * k; i++){
            if(csum < 0){
                csum = arr[i % arr.length];
            }else{
                csum += arr[i % arr.length];
            }
            
            if(csum > osum){
                osum = csum;
            }
        }
        return osum;
    }
    
    public int kConcatenationMaxSum(int[] arr, int k) {
        long sum = 0;
        long mod = (long)(1e9 + 7);
        for(int val : arr) sum += val;
        long val;
        if(k == 1){
            val = kadanes(arr,1);
        }else if(sum < 0){
            val = kadanes(arr,2);
        }else{
            val = kadanes(arr,2) + (k - 2) * sum;
        }
        
        if(val < 0) return 0;
        else return (int)(val % mod);
    }
}