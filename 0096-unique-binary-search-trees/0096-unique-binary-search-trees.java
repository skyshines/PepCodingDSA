class Solution {
    public int numTrees(int n) {
        //nth catalan number
        //desi submission
        
        int[] cn = new int[n + 1];
        cn[0] = cn[1] = 1;
        
        for(int i = 2; i <= n ; i++){
            
            for(int j = 0; j < i; j++){
                cn[i] += cn[j] * cn[i - 1 - j];
            }
        }
        
        return cn[n];
    }
}