class Solution {
    public class Edge{
        int src;
        int nbr;
        int wt;
        
        Edge(int src,int nbr,int wt){
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }
    }
    
    public class Pair{
        int vtx;
        int cost;
        
        Pair(int vtx, int cost){
            this.vtx = vtx;
            this.cost = cost;
        }
    }
    
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList< Edge>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for(int[] flight : flights){
            graph[flight[0]].add(new Edge(flight[0],flight[1],flight[2]));
        }
        
        int[] path = new int[n];
        Arrays.fill(path, Integer.MAX_VALUE);
        path[src] = 0;
        
        LinkedList<Pair> queue = new LinkedList<>();
        queue.add(new Pair(src, 0));
        k++;
        
        
        while(queue.size() > 0 && k-- > 0){
            int size = queue.size();
            
            while(size-- > 0){
                Pair rem = queue.remove();
                
                for(Edge edge : graph[rem.vtx]){
                    if(rem.cost + edge.wt < path[edge.nbr]){
                        path[edge.nbr] = rem.cost + edge.wt;
                        queue.add(new Pair(edge.nbr, path[edge.nbr]));
                    }
                }
            }
            
        }
        
        if(path[dst] == Integer.MAX_VALUE){
            return -1;
        }else{
            return path[dst];
        }
    }
}



























