class Solution {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
	    
	    for(int i = dp.length - 2; i >= 0; i--){
	        for(int j = dp[0].length - 2; j >= 0; j--){
	            if(word1.charAt(i) == word2.charAt(j)){
	                dp[i][j] = dp[i + 1][j + 1] + 1;
	            }else{
	                dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
	            }
	        }
	    }
        
        int lcs = dp[0][0];
        return word1.length() + word2.length() - 2 * lcs;
    }
}