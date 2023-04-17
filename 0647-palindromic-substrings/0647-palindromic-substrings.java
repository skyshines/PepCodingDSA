class Solution {
    public int countSubstrings(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        
        int count = 0;
        
        for(int gap = 0; gap < s.length(); gap++){
            for(int i = 0, j = gap; j < dp.length; i++, j++){
                if(gap == 0){
                    dp[i][j] = true;
                }else if(gap == 1){
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                }else{
                    dp[i][j] = s.charAt(i) == s.charAt(j) ? dp[i + 1][j - 1] : false;
                }
                
                if(dp[i][j] == true) count++;
            }
        }
        
        
        return count;
    }
}