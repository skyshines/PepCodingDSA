class Solution {
    public int topToBottom(int[][] grid,int i1,int j1,int i2,int j2,int[][][][] dp){
        if(i1 >= grid.length || j1 >= grid[0].length || i2 >= grid.length || j2 >= grid[0].length|| grid[i1][j1] == -1 || grid[i2][j2] == -1){
            return Integer.MIN_VALUE;
        }
        
        if(i1 == grid.length - 1 && j1 == grid[0].length - 1){
            return grid[i1][j1];
        }
        
        if(dp[i1][j1][i2][j2] != 0){
            return dp[i1][j1][i2][j2];
        }
        
        int cheeriesofcurrentposition = 0;
        
        if(i1 == i2 && j1 == j2){
            cheeriesofcurrentposition += grid[i1][j1];
        }else{
            cheeriesofcurrentposition += grid[i1][j1] + grid[i2][j2];
        }
        
        //four calls for four cases hh, hv,vh,vv
        
        int f1 = topToBottom(grid,i1 + 1, j1, i2 + 1, j2,dp);
        int f2 = topToBottom(grid,i1 + 1, j1, i2, j2 + 1,dp);
        int f3 = topToBottom(grid,i1,j1 + 1,i2 + 1,j2,dp);
        int f4 = topToBottom(grid,i1,j1 + 1,i2,j2 + 1,dp);
        
        int max = Math.max(Math.max(f1, f2), Math.max(f3, f4));
        
        dp[i1][j1][i2][j2] = cheeriesofcurrentposition + max;
        return cheeriesofcurrentposition + max;
        
    }
    
    
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int ans = topToBottom(grid,0,0,0,0,new int[n][n][n][n]);
        if(ans < 0){
            return 0;
        }else{
            return ans;
        }
    }
}
/*

backtracking solution bruteforce
class Solution {
    public int max;
    public void bottomToTop(int[][] grid,int i,int j,int c1){
        if(i < 0 || j < 0 || grid[i][j] == -1){
            return;
        }
        
        if(i == 0 && j == 0){
            max = (int)Math.max(max,c1);
            return;
        }
        
        int cap = grid[i][j];
        
        grid[i][j] = 0;
        
        bottomToTop(grid,i,j-1,c1 + cap);
        bottomToTop(grid,i-1,j,c1 + cap);
        
        grid[i][j] = cap;
        return;
        
    }
    public void topToBottom(int[][] grid,int i,int j,int c1){
        if(i >= grid.length || j >= grid[0].length || grid[i][j] == -1){
            return;
        }
        
        
        int n = grid.length;
        if(i == n - 1 && j == n - 1){
            bottomToTop(grid,n-1,n-1,c1);
            return;
        }
        
        int cap = grid[i][j];
        
        grid[i][j] = 0;
        
        topToBottom(grid,i,j+1,c1 + cap);
        topToBottom(grid,i+1,j,c1 + cap);
        
        grid[i][j] = cap;
        return;
        
    }
    public int cherryPickup(int[][] grid) {
        if(grid.length == 1){
            return grid[0][0];
        }
        max = 0;
        topToBottom(grid,0,0,0);
        return max;
    }
}

*/