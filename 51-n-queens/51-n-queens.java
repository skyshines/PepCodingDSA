class Solution {
    List<List<String>> ans;
    public boolean isQueenSafe(int[][] maze,int row,int col){
        for(int i = row - 1, j = col; i >= 0; i--){
            if(maze[i][j] == 1) return false;
        }
        
        for(int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--,j--){
            if(maze[i][j] == 1) return false;
        }
        
        for(int i = row - 1, j = col + 1; i >= 0 && j < maze[0].length; i--,j++){
            if(maze[i][j] == 1) return false;
        }
        
        return true;
    }
    
    public void placeQueen(int[][] maze,int row){
        if(row == maze.length){
            ArrayList<String> currans = new ArrayList<>();
            
            for(int[] m : maze){
                String s = "";
                for(int val : m){
                    if(val == 0) s+=".";
                    else s += "Q";
                }
                
                currans.add(s);
            }
            
            ans.add(currans);
            
            return;
        }
        
        
        for(int col = 0; col < maze[0].length; col++){
            if(isQueenSafe(maze,row,col)){
                maze[row][col] = 1;
                placeQueen(maze,row + 1);
                maze[row][col] = 0;
            }
        }
        
    }
    
    public List<List<String>> solveNQueens(int n) {
        int[][] maze = new int[n][n];
        ans = new ArrayList<List<String>>();
        placeQueen(maze,0);
        
        return ans;
    }
}