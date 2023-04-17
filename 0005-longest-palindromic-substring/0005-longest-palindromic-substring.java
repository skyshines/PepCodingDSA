class Solution {
    public String longestPalindrome(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        String ans = "";
        
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
                    if(gap + 1 > ans.length()) ans = s.substring(i, j + 1);
                }
            }
        }
        
        return ans;
    }
}