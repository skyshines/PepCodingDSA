class Solution {
    public void reverse(int[] arr,int lo, int hi){
        while(lo < hi){
            int temp = arr[lo];
            arr[lo] = arr[hi];
            arr[hi] = temp;
            
            lo++;
            hi--;
        }
    }
    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> ans = new ArrayList<>();
        
        for(int i = arr.length - 1; i >= 0; i--){
            int maxIdx = i;
            
            for(int j = i - 1; j >= 0; j--){
                if(arr[maxIdx] < arr[j]) maxIdx = j;
            }
            
            //max at correct place
            if(maxIdx == i) continue;
            else{
                reverse(arr, 0, maxIdx);
                ans.add(maxIdx + 1);
                
                reverse(arr, 0, i);
                ans.add(i + 1);
            } 
        }
        
        return ans;
    }
}