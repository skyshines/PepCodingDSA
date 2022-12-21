class Solution {
        public boolean isScramble3(String s1, String s2,int s1i, int s2i,int len,Boolean[][][] dp) {
            
            
        if(s1.substring(s1i,s1i + len).equals(s2.substring(s2i,s2i + len))){
            dp[s1i][s2i][len] = true;
            return true;
        }
        if(dp[s1i][s2i][len] != null){
            return dp[s1i][s2i][len];
            }
        
        for(int i = 1; i < len; i++){
            if((isScramble3(s1,s2,s1i,s2i,i,dp) && isScramble3(s1,s2,s1i + i,s2i + i, len - i,dp)) ||
               (isScramble3(s1,s2,s1i,s2i + len - i,i,dp) && isScramble3(s1,s2,s1i + i,s2i,len - i,dp))){
                dp[s1i][s2i][len] = true;
                return true;
            }
        }
       dp[s1i][s2i][len] = false;
       return false;
    }
    
    
    
    
    public boolean isScramble1(String s1, String s2) {
        if(s1.equals(s2)){
            return true;
        }
        
        if(s1.length() != s2.length()){
            return false;
        }
        
        int n = s1.length();
        
        for(int i = 1; i < n; i++){
            if(isScramble(s1.substring(0,i),(s2.substring(0,i))) && isScramble(s1.substring(i),(s2.substring(i))) ||
               (isScramble(s1.substring(0,i),(s2.substring(n - i)))) && isScramble(s1.substring(i),(s2.substring(0,n - i)))){
                return true;
            }
        }
       
       return false;
    } 
    
    
    public boolean isScramble(String s1, String s2) {
        
        //return isScramble1(s1,s2);
        int n = s1.length();
        return isScramble3(s1,s2,0,0,s1.length(),new Boolean[n][n][n + 1]);
    }
}