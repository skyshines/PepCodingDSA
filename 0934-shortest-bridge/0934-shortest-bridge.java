class Solution {
    int[][] dirs = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    
    public void dfs(int[][] grid, int row, int col,Queue<int[]> queue,boolean[][] visited){
        //visited[row][col] = true; // visisted
        grid[row][col] = -1;
        queue.add(new int[]{row, col});
        
        for(int i = 0; i < 4; i++){
            int rowdash = row + dirs[i][0];
            int coldash = col + dirs[i][1];
            
            if(rowdash < 0 || coldash < 0 || rowdash >= grid.length || coldash >= grid[0].length || visited[rowdash][coldash] == true || grid[rowdash][coldash] != 1){
                continue;
            }
            
            dfs(grid, rowdash, coldash, queue, visited);
        }
        
    }
    
    public int shortestBridge(int[][] grid) {
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        boolean flag = false;
        
        for(int i = 0; i < grid.length && flag == false; i++){
            for(int j = 0; j < grid[0].length && flag == false; j++){
                if(grid[i][j] == 1){
                    dfs(grid, i , j, queue, visited);
                    flag = true;
                }
            }
        }
        
        int lev = 0;
        
        while(queue.size() > 0){
            int size = queue.size();
            
            for(int j = 0; j < size; j++){
                int[] p = queue.remove();
                
               //visited[p[0]][p[1]] = true; //visited
                
                for(int i = 0; i < 4; i++){
                    int rowdash = p[0] + dirs[i][0];
                    int coldash = p[1] + dirs[i][1];

                    if(rowdash < 0 || coldash < 0 || rowdash >= grid.length || coldash >= grid[0].length || grid[rowdash][coldash] == -1){
                        continue;
                    }

                    if(grid[rowdash][coldash] == 0){
                        queue.add(new int[]{rowdash, coldash});
                        grid[rowdash][coldash] = -1;
                    }else if(grid[rowdash][coldash] == 1){
                        return lev;
                    }
                }
            }
            
            lev++;
        }
        
        return 1;
    }
}

//using Class for interview purpose
// class Solution {
//     int[][] dirs = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    
//     public class Pair{
//         int row;
//         int col;
        
//         Pair(int row, int col){
//             this.row = row;
//             this.col = col;
//         }
//     }
    
//     public void dfs(int[][] grid, int row, int col,Queue<Pair> queue){
//         grid[row][col] = -1; // visisted
//         queue.add(new Pair(row, col));
        
//         for(int i = 0; i < 4; i++){
//             int rowdash = row + dirs[i][0];
//             int coldash = col + dirs[i][1];
            
//             if(rowdash < 0 || coldash < 0 || rowdash >= grid.length || coldash >= grid[0].length || grid[rowdash][coldash] != 1){
//                 continue;
//             }
            
//             dfs(grid, rowdash, coldash, queue);
//         }
        
//     }
    
//     public int shortestBridge(int[][] grid) {
//         Queue<Pair> queue = new ArrayDeque<>();
//         boolean flag = false;
        
//         for(int i = 0; i < grid.length && flag == false; i++){
//             for(int j = 0; j < grid[0].length && flag == false; j++){
//                 if(grid[i][j] == 1){
//                     dfs(grid, i , j, queue);
//                     flag = true;
//                 }
//             }
//         }
        
//         int lev = 0;
        
//         while(queue.size() > 0){
//             int size = queue.size();
            
//             for(int j = 0; j < size; j++){
//                 Pair p = queue.remove();
                
//                 grid[p.row][p.col] = -1; //visited
                
//                 for(int i = 0; i < 4; i++){
//                     int rowdash = p.row + dirs[i][0];
//                     int coldash = p.col + dirs[i][1];

//                     if(rowdash < 0 || coldash < 0 || rowdash >= grid.length || coldash >= grid[0].length || grid[rowdash][coldash] == -1){
//                         continue;
//                     }

//                     if(grid[rowdash][coldash] == 0){
//                         queue.add(new Pair(rowdash, coldash));
//                     }else if(grid[rowdash][coldash] == 1){
//                         return lev;
//                     }
//                 }
//             }
            
//             lev++;
//         }
        
//         return 1;
//     }
// }
