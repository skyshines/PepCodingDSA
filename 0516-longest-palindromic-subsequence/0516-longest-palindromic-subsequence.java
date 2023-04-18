class Solution {
    public int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length()][s.length()];
        
        for(int gap = 0; gap < s.length(); gap++){
            for(int i = 0, j = gap; j < dp[0].length; i++, j++){
                int startChar = s.charAt(i);
                int endChar = s.charAt(j);
                
                if(gap == 0){
                    dp[i][j] = 1;
                }else if(gap == 1){
                    if(startChar == endChar){
                        dp[i][j] = 2;
                    }else{
                        dp[i][j] = 1;
                    }
                }else{
                    if(startChar == endChar){
                        dp[i][j] = dp[i + 1][j - 1] + 2;
                    }else{
                        dp[i][j] = dp[i + 1][j] > dp[i][j - 1] ? dp[i + 1][j] : dp[i][j - 1];
                    }
                }
            }
        }
        
        return dp[0][s.length() - 1];
    }
}