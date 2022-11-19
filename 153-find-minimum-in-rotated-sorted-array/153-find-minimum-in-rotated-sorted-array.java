class Solution {
    public int findMin(int[] arr) {
        int lo = 0; int hi = arr.length - 1;
        
        //check array is not rotated
        if(arr[lo] <= arr[hi]){
            return arr[lo];
        }
        
        
        while(lo <= hi){
            int mid = lo + (hi - lo) / 2;
            
            if(arr[mid] > arr[mid +1]){ 
                /*reason mid + 1upar aya consider test case 5 1 2 3 4 mid - 1bhale exist na kare mid + 1humesha exit karega and because of this we are tesnion free and dont have to check mid + 1 ya mid - 1 exist karega ya nhi*/
                return arr[mid + 1];
            }else if(arr[mid] < arr[mid - 1]){
                return arr[mid];
            }else if(arr[lo] <= arr[mid]){
                lo = mid + 1; 
            }else if(arr[mid] <= arr[hi]){
                hi = mid - 1;
            }
        }
        
        return -1;
    }
}