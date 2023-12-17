class Solution {
    public int minSteps(int n) {
        if(n == 1) return 0;
        
        int ans = 0;
        
        //prime factorisation
        
        for(int i = 2; i * i <= n; i++){
            int count = 0;
            
            while(n % i == 0){
                count++;
                n = n / i;
            }
            
            ans += i * count;
        }
        
        if(n != 1){
            ans += n;
        }
        
        return ans;
    }
}