class Solution {
    public int countPalindromicSubsequences(String s) {
        long[][] dp = new long[s.length()][s.length()];
        int[] next = new int[s.length()];
        int[] prev = new int[s.length()];
        long mod = (long)1e9 + 7;
        
        HashMap<Character, Integer> hm = new HashMap<>();
        
        for(int i = next.length - 1; i >= 0; i--){
            char ch = s.charAt(i);
            
            if(hm.containsKey(ch) == false){
                next[i] = s.length();
            }else{
                next[i] = hm.get(ch);
            }
            
            hm.put(ch, i);
        }
        
        hm.clear();
        
        for(int i = 0; i < prev.length; i++){
            char ch = s.charAt(i);
            
            if(hm.containsKey(ch) == false){
                prev[i] = -1;
            }else{
                prev[i] = hm.get(ch);
            }
            
            hm.put(ch, i);
        }
        
        
        //Gap Strategy
        
        for(int gap = 0; gap < s.length(); gap++){
            for(int i = 0, j = gap; j < s.length(); i++, j++){
                if(gap == 0){
                    dp[i][j] = 1;
                }else if(gap == 1){
                    dp[i][j] = 2;
                }else{
                    char startChar = s.charAt(i);
                    char endChar = s.charAt(j);
                    
                    if(startChar == endChar){
                        int nextIndexOfStartChar = next[i];
                        int prevIndexOfEndChar =  prev[j];
                        
                        dp[i][j] = 2 * dp[i + 1][j - 1];
                        
                        if(nextIndexOfStartChar > prevIndexOfEndChar){
                            dp[i][j] += 2;
                        }else if(nextIndexOfStartChar == prevIndexOfEndChar){
                            dp[i][j] += 1;
                        }else{
                            dp[i][j] -= dp[nextIndexOfStartChar + 1][prevIndexOfEndChar - 1];
                        }
                    }else{
                        dp[i][j] = dp[i + 1][j] + dp[i][j - 1] - dp[i + 1][j - 1];
                    }
                }
                
                dp[i][j] = (dp[i][j] + mod) % mod;
             }
        }
        
        return (int)dp[0][s.length() - 1];
    }
}