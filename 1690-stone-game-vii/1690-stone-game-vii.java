class Solution {
    public int stoneGameVII(int[] stones) {
        int sum = 0;
        int[] prefix = new int[stones.length];
        
        for(int i = 0; i < stones.length; i++){
            sum += stones[i];
            prefix[i] = sum;
        }
        
        return tabulation(stones,prefix);
    }
    
    public int stoneGameVIIMemoization(int[] stones) {
        int sum = 0;
        int[] prefix = new int[stones.length];
        
        for(int i = 0; i < stones.length; i++){
            sum += stones[i];
            prefix[i] = sum;
        }
        
        Integer[][] dp = new Integer[stones.length][stones.length];
        //changing paramteres -> i, j, sum
        //not including sum into memo dp array becuase it is dependent on i,j and can be calculated based on i, j;
        
        return memoization(stones,0,stones.length - 1,prefix, dp);
    }
    
    public int memoization(int[] stones,int i,int j,int[] prefix,Integer[][] dp){
        if(i >= j) return 0; // no element left to get score
        
        if(dp[i][j] != null) return dp[i][j];
        
        int sum = prefix[j] - (i == 0 ? 0 : prefix[i - 1]);
        
        //ith choose
        int scoreI = (sum - stones[i]) - memoization(stones,i + 1,j,prefix, dp);
        //jth choose
        int scoreJ = (sum - stones[j]) - memoization(stones,i,j - 1,prefix, dp);
        
        dp[i][j] = Math.max(scoreI, scoreJ);
        
        //returnning optimal choose out of i, j;
        return dp[i][j];
    }
    
    public int tabulation(int[] stones,int[] prefix){
        int[][] dp = new int[stones.length][stones.length];
        
        for(int gap = 0; gap < stones.length; gap++){
            for(int i = 0, j = gap; j < stones.length; i++, j++){
                if(i == j){
                    dp[i][j] = 0;
                }else{
                    int sum = prefix[j] - (i == 0 ? 0 : prefix[i - 1]);
        
                    //ith choose
                    int scoreI = (sum - stones[i]) - dp[i + 1][j];
                    //jth choose
                    int scoreJ = (sum - stones[j]) - dp[i][j - 1];

                    dp[i][j] = Math.max(scoreI, scoreJ);
                }
            }
        }
        
        return dp[0][stones.length - 1];
    }
}

