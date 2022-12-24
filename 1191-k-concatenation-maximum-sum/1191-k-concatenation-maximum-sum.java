class Solution {
    static long mod = (long)(1e9 + 7);
    
    public int kadanes(int[] arr, int k){
        long csum = arr[0]; int osum = arr[0];
        
        for(int i = 1; i < arr.length * k; i++){
            if(csum < 0){
                csum = arr[i % arr.length];
            }else{
                csum += arr[i % arr.length];
            }
            
            if(csum > osum){
                osum = (int)csum;
            }
        }
        return osum;
    }
    
    public int kConcatenationMaxSum(int[] arr, int k) {
        long sum = 0;
        
        for(int val : arr) sum += val;
        long val;
        if(k == 1){
            val = kadanes(arr,1) % mod;
        }else if(sum < 0){
            val = kadanes(arr,2) % mod;
        }else{
            val = (long)((kadanes(arr,2) + (k - 2) * sum) % mod);
        }
        
        if(val < 0) return 0;
        else return (int)val;
    }
}