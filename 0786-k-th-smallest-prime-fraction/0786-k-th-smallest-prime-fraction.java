class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int n = arr.length;
        double lo = (1.0 * arr[0])/(1.0 * arr[n - 1]);
        double hi = 1;
        
        while(lo < hi){
            double mid = (lo + hi) / 2;
            
            int[] count = helper(arr, mid);
            //count, num, deno
            
            if(count[0] < k){
                lo = mid;
            }else if(count[0] > k){
                hi = mid;
            }else{
                return new int[]{count[1], count[2]};
            }
        }
        
        return new int[]{};
        
    }
    
    public int[] helper(int[] arr, double target){
        int n = arr.length;
        
        int count = 0;
        int i = 0;
        
        //initialising num, den, with smallest fraction
        int num = arr[0];
        int den = arr[n - 1];
        
        
        for(int j = 1; j < n; j++){
            /*
            arr[i]/arr[j] <= target
            i++;
            */
            
            while(arr[i] <= target * arr[j]){
                i++;
            }
            
            count += i;
            
            if(i > 0 && arr[i - 1] * den > arr[j] * num){
                num = arr[i - 1];
                den = arr[j];
            }   
        }
        
        return new int[]{count, num, den};
    }
}