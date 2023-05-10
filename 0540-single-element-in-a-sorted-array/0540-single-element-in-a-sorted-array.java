class Solution {
    public int singleNonDuplicate(int[] arr) {
        int lo = 0;
        int hi = arr.length - 1;
        
        while(lo <= hi){
            if(lo == hi){
                return arr[lo];
            }else{
                int mid = lo + (hi - lo) / 2;
                
                if(arr[mid] == arr[mid + 1]){
                    int rightCount = hi - mid + 1;
                    
                    if(rightCount % 2 == 1){
                        lo = mid + 2;
                    }else{
                        hi = mid - 1;
                    }
                }else if(arr[mid - 1] == arr[mid]){
                    int leftCount = mid - lo + 1;
                    
                    if(leftCount % 2 == 1){
                        hi = mid - 2;
                    }else{
                        lo = mid + 1;
                    }
                }else if(arr[mid] != arr[mid + 1] && arr[mid - 1] != arr[mid]){
                    return arr[mid];
                }
            }
        }
        
        return 0;
    }
}