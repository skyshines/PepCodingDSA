class Solution {
    public int countTriplets(int[] arr) {
        int ans = 0;
        
         for(int i = 0; i < arr.length; i++){
             int val = arr[i];
             
             for(int k = i + 1; k < arr.length; k++){
                 val ^= arr[k];
                 
                 if(val == 0){
                     ans += k - i;
                 }
             }
         }
        
        return ans;
    }
}