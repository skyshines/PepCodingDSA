//{ Driver Code Starts
// Initial Template for Java
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>>adj = new ArrayList<>();
            for(int i = 0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++){
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            ArrayList<Integer>ans = obj.articulationPoints(V, adj);
            for (int i =0 ;i < ans.size (); i++) 
                System.out.print (ans.get (i) + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution
{
    //Function to return Breadth First Traversal of given graph.
    int[] parent;
    int[] discovery;
    int[] low;
    int time = 0;
    boolean[] visited;
    boolean[] articulationPoint;
    
    public ArrayList<Integer> articulationPoints(int V,ArrayList<ArrayList<Integer>> graph)
    {
        parent = new int[V];
        discovery = new int[V];
        low = new int[V];
        visited = new boolean[V];
        articulationPoint = new boolean[V];
        time = 0;
        
        parent[0] = -1;
        dfs(0, graph);
        
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        for(int i = 0; i < articulationPoint.length; i++){
            if(articulationPoint[i] == true){
                ans.add(i);
            }
        }
        
        if(ans.size() == 0) ans.add(-1);
        return ans;
        
    }
    
    public void dfs(int src,ArrayList<ArrayList<Integer>> graph){
        int u = src;
        visited[u] = true;
        
        low[u] = discovery[u] = time;
        time++;
        int count = 0;
        
        for(int nbr : graph.get(src)){
            
            int v = nbr;
            if(parent[u] == v){
                continue;
            }else if(visited[v] == true){
                low[u] = Math.min(low[u], discovery[v]);
            }else{
                parent[v] = u;
                
                count++;
                dfs(v, graph);
                
                low[u] = Math.min(low[u], low[v]);
                
                if(parent[u] == -1){
                    if(count >= 2){
                        articulationPoint[u] = true;
                    }
                }else{
                    if(low[v] >= discovery[u]){
                        articulationPoint[u] = true;
                    }
                }
            }
        }
    }
}