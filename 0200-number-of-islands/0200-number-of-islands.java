class Solution {
    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public void dfs(char[][] grid, int row, int col){
        //visited
        grid[row][col] = '#';
        
        for(int[] dir : dirs){
            int rowdash = row + dir[0];
            int coldash = col + dir[1];
            
            if(rowdash < 0 || coldash < 0 || rowdash >= grid.length || coldash >= grid[0].length || grid[rowdash][coldash] == '#' || grid[rowdash][coldash] == '0') continue;
            
            dfs(grid, rowdash, coldash);
        }
    }
    
    public int numIslands(char[][] grid) {
        int countOfIslands = 0;
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1'){
                    dfs(grid, i, j);
                    countOfIslands++;
                }
            }
        }
        
        return countOfIslands;
    }
}