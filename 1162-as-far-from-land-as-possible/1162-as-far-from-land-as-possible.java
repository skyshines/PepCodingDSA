class Solution {
    public class Pair{
        int row;
        int col;
        
        Pair(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
    
    int[][] dirs = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
    
    public int maxDistance(int[][] grid) {
        Queue<Pair> queue = new ArrayDeque<>();
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid.length; j++){
                if(grid[i][j] == 1){
                    queue.add(new Pair(i, j));
                }
            }
        }
        
        if(queue.size() == 0 || queue.size() == grid.length * grid[0].length){
            return -1;
        }
        
        int lev = 0;
        
        while(queue.size() > 0){
            int size = queue.size();
            
            for(int i = 0; i < size; i++){
                Pair p = queue.remove();
                
                for(int[] dir : dirs){
                    int rowdash = p.row + dir[0];
                    int coldash = p.col + dir[1];
                    
                    if(rowdash < 0 || coldash < 0 || rowdash >= grid.length || coldash >= grid[0].length || grid[rowdash][coldash] != 0){
                        continue;
                    }
                    
                    grid[rowdash][coldash] = 1; //visited
                    
                    queue.add(new Pair(rowdash, coldash));
                }
            }
            
            lev++;
        }
        
        return lev - 1;
    }
}