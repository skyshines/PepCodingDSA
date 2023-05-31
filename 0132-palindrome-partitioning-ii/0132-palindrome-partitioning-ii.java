class Solution {
    public int minCut(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        
        for(int gap = 0; gap < s.length(); gap++){
            for(int i = 0, j = gap; j < dp.length; i++, j++){
                if(gap == 0){
                    dp[i][j] = true;
                }else if(gap == 1){
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                }else{
                    if(s.charAt(i) == s.charAt(j)){
                        dp[i][j] = dp[i + 1][j - 1]; //middle part
                    }else{
                        dp[i][j] = false;
                    }
                }
            }
        }
        
        int[] strg = new int[s.length()]; //storage
        
        for(int j = 1; j < strg.length; j++){
            if(dp[0][j] == true){
                strg[j] = 0;
                continue;
            }
            
            int min = Integer.MAX_VALUE;
            
            for(int i = j; i >= 1; i--){
                if(dp[i][j] == true){
                    if(strg[i - 1] < min) min = strg[i - 1];
                }
            }
            
            strg[j] = min + 1;
        }
        
        return strg[s.length() - 1];
    }
}