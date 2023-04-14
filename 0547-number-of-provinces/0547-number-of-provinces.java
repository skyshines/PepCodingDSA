class Solution {
    public int findCircleNum(int[][] grid) {
        int countOfProvinces = 0;
        
        boolean[] visited = new boolean[grid.length];
        
        for(int vertex = 0; vertex < grid.length; vertex++){
            if(visited[vertex] == false){
                createComp(grid, vertex, visited);
                countOfProvinces++;
            }
        }
        
        return countOfProvinces;
    }
    
    public void createComp(int[][] grid, int src, boolean[] visited){
        //visited
        visited[src] = true;
        
        for(int nbr = 0; nbr < grid.length; nbr++){
            if(grid[src][nbr] == 1 && visited[nbr] == false){
                createComp(grid, nbr, visited);
            }
        }
    }
}