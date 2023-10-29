class Solution {
    public int minInsertions(String s) {
        int[][] dp = new int[s.length()][s.length()];
        
        for(int g = 0; g < s.length(); g++){
            for(int j = g, i = 0; j < dp.length; j++, i++){
                if(g == 0){
                    dp[i][j] = 1;
                }else{
                    if(s.charAt(j) == s.charAt(i)){
                        dp[i][j] = dp[i + 1][j - 1] + 2;
                    }else{
                        dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                    }
                }
            }
        }
        
        int lps = dp[0][s.length() - 1];
        return s.length() - lps;
    }
}