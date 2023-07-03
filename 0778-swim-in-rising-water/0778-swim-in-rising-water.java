class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        
        pq.add(new Pair(0,0,grid[0][0]));
        boolean[][] visited = new boolean[n][n];
        int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};
        
        while(pq.size() > 0){
            Pair rem = pq.remove();
            
            if(rem.row == n - 1 && rem.col == n - 1){
                return rem.msf;
            }
            
            if(visited[rem.row][rem.col] == true) continue;
            
            visited[rem.row][rem.col] = true;
            
            for(int[] dir : dirs){
                int rowdash = rem.row + dir[0];
                int coldash = rem.col + dir[1];
                
                if(rowdash < 0 || coldash < 0 || rowdash >= n || coldash >= n || visited[rowdash][coldash] == true) continue;
                
                pq.add(new Pair(rowdash,coldash, Math.max(rem.msf, grid[rowdash][coldash])));
            }
        }
        
        return 0;
    }
    
    public class Pair implements Comparable<Pair>{
        int row;
        int col;
        int msf; //max so far
        
        Pair(int row, int col, int msf){
            this.row = row;
            this.col = col;
            this.msf = msf;
        }
        
        public int compareTo(Pair o){
            return this.msf - o.msf;
        }
    }
}