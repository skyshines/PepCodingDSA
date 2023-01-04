class Solution {
    class Pair implements Comparable<Pair>{
        int row;
        int col;
        int height;
        
        Pair(int row, int col, int height){
            this.row = row;
            this.col = col;
            this.height = height;
        }
        
        public int compareTo(Pair o){
            return this.height - o.height;
        }
    }
    public int trapRainWater(int[][] heightMap) {
        int row = heightMap.length;
        int col = heightMap[0].length;
        
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        boolean[][] visited = new boolean[row][col];
        
        for(int i = 0;  i < heightMap.length; i++){
            for(int j = 0; j < heightMap[0].length; j++){
                if(i == 0 || j == 0 || i == heightMap.length - 1 || j == heightMap[0].length - 1){
                    pq.add(new Pair(i,j,heightMap[i][j]));
                    visited[i][j] = true;
                }
            }
        }
        
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        
        int water = 0;
        
        while(pq.size() > 0){
            Pair p = pq.remove();
            
            //checking neighbours and giving responsibility;
            for(int[] dir : dirs){
                int nrow = p.row + dir[0];
                int ncol = p.col + dir[1];
                
                if(nrow >= 0 && nrow < row && ncol >= 0 && ncol < col && visited[nrow][ncol] == false){
                    int nheight = heightMap[nrow][ncol];
                    
                    water += (int)Math.max(0,p.height - nheight);
                    
                    if(p.height <= heightMap[nrow][ncol]){
                        pq.add(new Pair(nrow,ncol,heightMap[nrow][ncol]));
                    }else{
                        pq.add(new Pair(nrow,ncol,p.height));
                    }
                    
                    visited[nrow][ncol] = true;
                }
            }
            
        }
        
        return water;
    }
}