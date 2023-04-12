class Solution {
    public class Edge{
        int src;
        int nbr;
        
        Edge(int src, int nbr){
            this.src = src;
            this.nbr = nbr;
        }
    }
    
    public boolean hasPath(ArrayList<Edge>[] graph,int src,int dest, boolean[] visited){
        if(src == dest){
            return true;
        }
        
        if(visited[src] == true){
            return false;
        }
        
        visited[src] = true;
        
        for(Edge edge : graph[src]){
            boolean nbrHasPath = hasPath(graph, edge.nbr, dest, visited);
            
            if(nbrHasPath == true){
                return true;
            }
        }
        
        return false;
    }
    
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<Edge>[] graph = new ArrayList[n];
        
        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int[] edge : edges){
            int v1 = edge[0];
            int v2 = edge[1];
            
            graph[v1].add(new Edge(v1, v2));
            graph[v2].add(new Edge(v2, v1));
        }
        
        boolean[] visited = new boolean[n];
        
        return hasPath(graph, source, destination, visited);
    }
}