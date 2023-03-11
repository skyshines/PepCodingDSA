class Solution {
    public int[] countBits(int n) {
        int[] arr = new int[n + 1];
        int mask = 1;
        
        for(int i = 1; i <= n; i++){
            if((i & mask) == 1){
                arr[i] = arr[(i >> 1)] + 1;
            }else{
                arr[i] = arr[(i >> 1)];
            }
        }
        
        return arr;
    }
}