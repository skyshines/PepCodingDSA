class Solution {
    public int helper(int m,int n,int i,int j){
        if(i >= m || j >= n) return 0;
        if(i == m - 1 && j == n - 1){
            return 1;
        }
        return helper(m,n,i+1,j) + helper(m,n,i,j+1); 
    }
    public int uniquePaths(int m, int n) {
        int[][] maze = new int[m][n];
        
        for(int i = m - 1; i >= 0; i--){
            for(int j = n - 1; j >= 0; j--){
                if(i == m - 1 || j == n - 1){
                    maze[i][j] = 1;
                }else{
                    maze[i][j] += maze[i + 1][j] + maze[i][j + 1];
                }
            }
        }
        
        return maze[0][0];
    }
}