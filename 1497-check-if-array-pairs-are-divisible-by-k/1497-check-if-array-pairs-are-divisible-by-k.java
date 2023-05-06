class Solution {
    public boolean canArrange(int[] arr, int k) {
        int[] fmap = new int[k];
        
        for(int val : arr){
            fmap[(val % k) < 0 ? (val % k) + k : (val % k)]++;
        }
        
        boolean ans = true;
        
        for(int i = 0; i <= (k - 1) / 2; i++){
            if(i == 0){
                if(fmap[i] % 2 != 0){
                    return false;
                }
            }else{
                if(fmap[i] != fmap[k - i]){
                    return false;
                }
            }
        }
        
        if(k % 2 == 0){
            return fmap[k / 2] % 2 == 0;
        }
        
        return true;
    }
}