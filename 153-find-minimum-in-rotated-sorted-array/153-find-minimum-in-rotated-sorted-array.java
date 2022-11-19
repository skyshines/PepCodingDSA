class Solution {
    public int findMin(int[] arr) {
        int lo = 0; int hi = arr.length - 1;
        
        //check array is not rotated
        if(arr[lo] <= arr[hi]){
            return arr[lo];
        }
        
        
        while(lo <= hi){
            int mid = lo + (hi - lo) / 2;
            
            if(mid > 0 && arr[mid] < arr[mid - 1]){
                return arr[mid];
            }
            
            if(mid < arr.length - 1 && arr[mid] > arr[mid +1]){
                return arr[mid + 1];
            }
            
            if(arr[lo] <= arr[mid]){
                lo = mid + 1; 
            }else if(arr[mid] <= arr[hi]){
                hi = mid - 1;
            }
        }
        
        return -1;
    }
}