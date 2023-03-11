class Solution {
    public int noOfSetBits(int x){
        int count = 0;
        
        while(x > 0){
            x -= (x & -x);
            count++;
        }
        
        return count;
    }
    public int[] countBits(int n) {
        int[] arr = new int[n + 1];
        for(int i = 1; i <= n; i++){
            arr[i] = noOfSetBits(i);
        }
        
        return arr;
    }
}