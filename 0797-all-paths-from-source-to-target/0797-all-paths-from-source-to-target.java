class Solution {
    static List<List<Integer>> ans;
    
    public void getPath(int[][] graph, int src, int dest,boolean[] visited, ArrayList<Integer> psf){
        if(src == dest){
            ans.add(new ArrayList<>(psf));
            return;
        }
        
        visited[src] = true;
        
        for(int nbr : graph[src]){
            if(visited[nbr] == true) continue;
            
            psf.add(nbr);
            getPath(graph, nbr, dest, visited, psf);
            psf.remove(psf.size() - 1);
        }
        
        visited[src] = false;
    }
    
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        ans = new ArrayList<>();
        boolean[] visited = new boolean[graph.length];
        
        ArrayList<Integer> psf = new ArrayList<Integer>();
        psf.add(0);
        
        getPath(graph, 0, graph.length - 1, visited, psf);
        return ans;
    }
}