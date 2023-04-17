class Solution {
    public String longestPalindrome(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int ans = 0;
        int startIndex = 0;
        int endIndex = 0;
        
        for(int gap = 0; gap < s.length(); gap++){
            for(int i = 0, j = gap; j < dp[0].length; i++, j++){
                if(gap == 0){
                   dp[i][j] = true; 
                }else if(gap == 1){
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                }else{
                    dp[i][j] = s.charAt(i) == s.charAt(j) ? dp[i + 1][j - 1] : false;
                }
                
                if(dp[i][j] == true){
                    if(true){
                        ans = gap + 1;
                        startIndex = i;
                        endIndex = j;
                    }
                }
                
            }
        }
        
        return s.substring(startIndex, endIndex + 1);
    }
}