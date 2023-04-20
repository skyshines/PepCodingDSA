class Solution {
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[p.length() + 1][s.length() + 1];
        dp[p.length()][s.length()] = true;
        
        //last column
        for(int i = p.length() - 1; i >= 0; i--){
            if(p.charAt(i) == '*'){
                dp[i][s.length()] = dp[i + 1][s.length()];
            }
        }
        
        for(int i = p.length() - 1; i >= 0; i--){
            for(int j = s.length() - 1; j >= 0; j--){
                char patChar = p.charAt(i);
                
                if(patChar == '?'){
                    dp[i][j] = dp[i + 1][j + 1]; //checking diagonally
                }else if(patChar == '*'){
                    dp[i][j] = dp[i + 1][j] || dp[i][j + 1]; 
                }else{
                    char strChar = s.charAt(j);
                    
                    if(patChar == strChar){
                        dp[i][j] = dp[i + 1][j + 1];
                    }else{
                        dp[i][j] = false;
                    }
                }
            }
        }
        
        return dp[0][0];
    }
}