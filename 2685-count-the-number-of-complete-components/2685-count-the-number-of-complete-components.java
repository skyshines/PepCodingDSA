class Solution {
    long bit;
    HashSet<Integer> hs;
    
    class Edge{
        int src;
        int nbr;
        
        Edge(int src, int nbr){
            this.src = src;
            this.nbr = nbr;
        }
    }
    
    public void dfs(ArrayList<Edge>[] graph,boolean[] visited, int src){
        bit = (bit | (1L << (src * 1L)));
        hs.add(src);
        
        visited[src] = true;
        
        for(Edge e : graph[src]){
            if(visited[e.nbr] == false) dfs(graph, visited, e.nbr);
        }
    }
    public int countCompleteComponents(int n, int[][] edges) {
        ArrayList<Edge>[] graph = new ArrayList[n];
        long[] graph2 = new long[n];
        
        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int[] edge : edges){
            int src = edge[0];
            int nbr = edge[1];
            
            graph[src].add(new Edge(src, nbr));
            graph[nbr].add(new Edge(nbr, src));
            
            graph2[src] = (graph2[src] | (1L << (nbr * 1L)));
            graph2[nbr] = (graph2[nbr] | (1L << (src * 1L)));
        }
        
        int count = 0;
        boolean[] visited = new boolean[n];
        
        
        for(int i = 0; i < n; i++){
            if(visited[i] == true) continue;
            
            bit = 0;
            hs = new HashSet<>();
            dfs(graph, visited, i);
            
            if(hs.size() <= 2){
                count++;
                continue;
            }
            
            boolean flag = true;
            for(int val : hs){
                long t = bit;
                t = (t & ~(1L << val));
                
                if((t & graph2[val]) == t){
                    
                }else{
                    flag = false;
                    break;
                }
            }
            
            if(flag == true) count++;
            
        }
        
        return count;
    }
}