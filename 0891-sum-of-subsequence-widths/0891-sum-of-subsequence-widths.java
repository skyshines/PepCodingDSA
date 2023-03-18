class Solution {
    public int sumSubseqWidths(int[] nums) {
        
        
        Arrays.sort(nums);
        int mod = (int)1e9 + 7;
        long ans = 0L;
        int n = nums.length;
        long pow = 1;
      
        for(int i = 0; i < nums.length; i++){
            ans += (nums[i] * pow - (nums[n - i - 1] * pow)); 
            ans %= mod;
            pow = (pow * 2) % mod;
        }    
            
        return (int)((ans + mod) % mod);    
    }
}

/*

class Solution {
    public int sumSubseqWidths(int[] nums) {
        
        
        Arrays.sort(nums);
        int mod = 1000000007;
        long ans = 0L;
        int n = nums.length;
        
        //pre calculations
        long[] pow = new long[nums.length];
        pow[0] = 1;
        
        for(int i = 1; i < nums.length; i++){
            pow[i] = 2 * (pow[i - 1]) % mod;
        }
        
        
        for(int i = 0; i < nums.length; i++){
            ans += (nums[i] * (pow[i] - pow[n - 1 - i]));
            ans %= mod;
        }    
            
        return (int)(ans);    
    }
}

*/