class Solution {
    int[] parent;
    int[] low;
    int[] discovery;
    
    int time;
    boolean[] visited;
    List<List<Integer>> ans;
    
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        
        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }
        
        for(List<Integer> edge : connections){
            graph.get(edge.get(0)).add(edge.get(1));
            graph.get(edge.get(1)).add(edge.get(0));
        }
        
        parent = new int[n];
        low = new int[n];
        discovery = new int[n];
        
        time = 0;
        visited = new boolean[n];
        ans = new ArrayList<>();
        
        dfs(0, graph);
        return ans;
    }
    
    public void dfs(int src,ArrayList<ArrayList<Integer>> graph){
        int u = src;
        low[u] = discovery[u] = time;
        time++;
        
        visited[u] = true;
        
        for(int nbr : graph.get(u)){
            int v = nbr;
            
            if(parent[u] == v){
                continue;
            }else if(visited[v] == true){
                low[u] = Math.min(low[u], discovery[v]);
            }else{
                parent[v] = u;
                dfs(v, graph);
                low[u] = Math.min(low[u], low[v]);
                
                if(low[v] > discovery[u]){
                    List<Integer> list = new ArrayList<>();
                    list.add(u);
                    list.add(v);
                    ans.add(list);
                }
            }
        }
    }
}