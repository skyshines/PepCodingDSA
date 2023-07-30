class Solution {
    boolean[][] visited;
    int osf;
    int[][] dirs = {{-1, 0},{1, 0},{0, 1},{0, -1}};
    
    public void dfs(int[][] grid, int r, int c){
        visited[r][c] = true;
        osf++;
        
        for(int[] dir : dirs){
            int rd = r + dir[0];
            int cd = c + dir[1];
            
            if(rd < 0 || cd < 0 || rd >= grid.length
               || cd >= grid[0].length || grid[rd][cd] == 0
               || visited[rd][cd] == true){
                continue;
            }
            
            dfs(grid, rd, cd);
        }
    }
    
    public int maxAreaOfIsland(int[][] grid) {
        int ans = 0;
        visited = new boolean[grid.length][grid[0].length];
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1 && visited[i][j] == false){
                    osf = 0;
                    dfs(grid, i, j);
                    if(osf > ans) ans = osf;
                }
            }
        }
        
        return ans;
    }
}