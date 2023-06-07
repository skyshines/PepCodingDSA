class Solution {
    public int minScoreTriangulation(int[] values) {
        int[][] dp = new int[values.length][values.length];
        
        for(int gap = 0; gap < dp.length; gap++){
            for(int i = 0, j = gap; j < dp[0].length; j++, i++){
                if(gap == 0){
                    dp[i][j] = 0;
                }else if(gap == 1){
                    dp[i][j] = 0;
                }else if(gap == 2){
                    dp[i][j] = values[i] * values[i + 1] * values[i + 2];
                }else{
                    int min = Integer.MAX_VALUE;
                    
                    for(int k = i + 1; k < j; k++){
                        int immediateTraingle = values[i] * values[j] * values[k];
                        int partOnLeft = dp[i][k];
                        int partOnRight = dp[k][j];
                        
                        int total = immediateTraingle + partOnLeft + partOnRight;
                        
                        if(total < min) min = total;
                    }
                    
                    dp[i][j] = min;
                }
            }
        }
        
        return dp[0][dp[0].length - 1];
    }
}