class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] xor = new int[arr.length + 1];
        
        for(int i = 1; i < xor.length; i++){
            xor[i] = (xor[i - 1] ^ arr[i - 1]);
        }
        
        int[] ans = new int[queries.length];
        int i = 0;
        
        for(int[] querie : queries){
            ans[i] = (xor[querie[0]] ^ xor[querie[1] + 1]); 
            i++;    
        }
        
        return ans;
    }
}