class Solution {
    public boolean isBipartite(int[][] graph) {
        
        Integer[] visited = new Integer[graph.length];
        
        for(int i = 0; i < graph.length; i++){
            if(visited[i] == null){
                ArrayDeque<Integer> queue = new ArrayDeque<>();
                
                int root = i;
                queue.add(root);
                int lev = 0;
                
                while(queue.size() > 0){
                    int size = queue.size();
                    
                    while(size-- > 0){
                        int node = queue.remove();
                        
                        if(visited[node] == null){
                            visited[node] = lev;
                        }else{
                            if(visited[node] != lev){
                                return false;
                            }
                        }
                        
                        for(int nbr : graph[node]){
                            if(visited[nbr] == null){
                                queue.add(nbr);
                            }
                        }
                        
                    }
                    
                    lev++;
                    
                }
            }
        }
        
        return true;
    }
    
    
}