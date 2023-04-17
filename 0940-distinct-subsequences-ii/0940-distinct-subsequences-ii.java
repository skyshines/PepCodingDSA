class Solution {
    public int distinctSubseqII(String s) {
        long[] dp = new long[s.length() + 1];
        dp[0] = 1; // base case blank
        long mod = (long)(1e9 + 7);
        
        HashMap<Character, Integer> lastOccurence = new HashMap<>();
        
        for(int i = 1; i < dp.length; i++){
            
            dp[i] = 2 * dp[i - 1];
            
            char ch = s.charAt(i - 1);
            
            if(lastOccurence.containsKey(ch) == true){
                int prevIdx = lastOccurence.get(ch) - 1;
                dp[i] -= dp[prevIdx];
            }
            
            lastOccurence.put(ch, i);
            
            dp[i] = dp[i] % mod;
        }
        
        return (int)((dp[s.length()] - 1 + mod) % mod);
    }
}