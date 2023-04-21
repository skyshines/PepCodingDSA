class Solution {
    public int minDistance(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        
        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){
                if(i == 0 && j == 0){
                    dp[i][j] = 0;
                }else if(i == 0){
                    dp[i][j] = j;
                }else if(j == 0){
                    dp[i][j] = i;
                }else{
                    char s1Char = s1.charAt(i - 1);
                    char s2Char = s2.charAt(j - 1);
                    
                    if(s1Char == s2Char){
                        dp[i][j] = dp[i - 1][j - 1];
                    }else{
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1]) + 1;
                    }
                }
            }
        }
        
        return dp[s1.length()][s2.length()];
    }
}