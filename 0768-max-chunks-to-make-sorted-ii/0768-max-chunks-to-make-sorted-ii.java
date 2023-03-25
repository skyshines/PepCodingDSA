class Solution {
    public int maxChunksToSorted(int[] arr) {
        int[] rmin = new int[arr.length + 1];
        
        rmin[rmin.length - 1] = Integer.MAX_VALUE;
        
        for(int i = arr.length - 1; i >= 0; i--){
            rmin[i] = arr[i] > rmin[i + 1] ? rmin[i + 1] : arr[i];
        }
        
        int lmax = 0;
        int count = 0;
        
        for(int i = 0; i < arr.length; i++){
            lmax = lmax > arr[i] ? lmax : arr[i];
            
            if(lmax <= rmin[i + 1]) count++;
        }
        
        return count;
    }
}