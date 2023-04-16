class Solution {
    int[][] dirs = {{-1, 0},{1, 0},{0, 1},{0, -1}};
    
    static int ans;
    
    public boolean anyNeighbourIsTwo(int[][] grid, int row, int col){
        
        for(int[] dir : dirs){
            int rowdash = row + dir[0];
            int coldash = col + dir[1];
            
            if(rowdash < 0 || coldash < 0 || rowdash >= grid.length || coldash >= grid[0].length ){
                continue;
            }
            
            if(grid[rowdash][coldash] == 2) return true;
        }
        
        return false;
    }
    
    public void hamiltonainPath(int[][] grid,int row,int col, int count){
        
        if(count == 0){
            if(anyNeighbourIsTwo(grid, row, col)){
                ans++;
            }    
            return;
        }
        
        //marking visited
        grid[row][col] = -1;
        
        for(int[] dir : dirs){
            int rowdash = row + dir[0];
            int coldash = col + dir[1];
            
            if(rowdash < 0 || coldash < 0 || rowdash >= grid.length || coldash >= grid[0].length || grid[rowdash][coldash] != 0 ){
                continue;
            }
            
            hamiltonainPath(grid, rowdash, coldash, count - 1);
        }
        
        //marking unvisited
        grid[row][col] = 0;
    }
    public int uniquePathsIII(int[][] grid) {
        //implementation of Hamiltonian Path on Matrix - represented graph
        
        int sourceRow = 0;
        int sourceCol = 0;
        int countZero = 0;
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    sourceRow = i;
                    sourceCol = j;
                }
                
                if(grid[i][j] == 0){
                    countZero++;
                }
            }
        }
    
        
        ans = 0;
        hamiltonainPath(grid, sourceRow, sourceCol, countZero);
        return ans;
    }
}