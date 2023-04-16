class Solution {
    public int uniquePathsWithObstacles(int[][] maze) {
        int m = maze.length;
        int n = maze[0].length;
        
        if(maze[m - 1][n - 1] == 1){
            return 0;
        }
        
        for(int i = m - 1; i >= 0; i--){
            for(int j = n - 1; j >= 0; j--){
                if(maze[i][j] == 1){
                    maze[i][j] = 0;
                    continue;
                }
                
                if(i == m - 1 && j == n - 1){
                    if(maze[m - 1][n - 1] == 1){
                        return 0;
                    }else{
                        maze[m - 1][n - 1] = 1;
                        continue;
                    }
                }
                
                if(i == m - 1 || j == n - 1){
                    if(i == m - 1){
                        maze[i][j] = maze[i][j + 1];
                    }else if(j == n - 1){
                        maze[i][j] = maze[i + 1][j];
                    }
                }else{
                    maze[i][j] += maze[i + 1][j] + maze[i][j + 1];
                }
            }
        }
        
        return maze[0][0];
    }
}