class Solution {
    public int stoneGameVII(int[] stones) {
        int sum = 0;
        for(int stone : stones) sum += stone;
        
        Integer[][] dp = new Integer[stones.length][stones.length];
        //changing paramteres -> i, j, sum
        //not including sum into memo dp array becuase it is dependent on i,j and can be calculated based on i, j;
        
        return memoization(stones,0,stones.length - 1,sum, dp);
    }
    
    public int memoization(int[] stones,int i,int j,int sum,Integer[][] dp){
        if(i >= j) return 0; // no element left to get score
        
        if(dp[i][j] != null) return dp[i][j];
        
        //ith choose
        int scoreI = (sum - stones[i]) - memoization(stones,i + 1,j,sum - stones[i], dp);
        //jth choose
        int scoreJ = (sum - stones[j]) - memoization(stones,i,j - 1,sum - stones[j], dp);
        
        dp[i][j] = Math.max(scoreI, scoreJ);
        
        //returnning optimal choose out of i, j;
        return dp[i][j];
    }
}
