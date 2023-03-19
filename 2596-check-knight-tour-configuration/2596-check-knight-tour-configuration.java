class Solution {
    int[] iarr = {-1,-2,-2,-1,1,2,2,1};
    int[] jarr = {-2,-1,1,2,2,1,-1,-2};
    
    public boolean helper(int i, int j,int move,int[][] grid){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid.length || grid[i][j] != move - 1){
            return false;
        }
        
        if(move == grid.length * grid.length){
            return true;
        }
        
        for(int k = 0; k < 8; k++){
            if(helper(i + iarr[k],j + jarr[k],move + 1,grid)){
                return true;
            }
        }
        
        return false;
    }
    public boolean checkValidGrid(int[][] grid) {
        return helper(0,0,1,grid);

    }
}