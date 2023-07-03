//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Gfg
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            // arraylist of arraylist to represent graph
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            int V = Integer.parseInt(sc.next());
            int E = Integer.parseInt(sc.next());
            
            for(int i =0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
                
            for(int i = 1; i <= E; i++)
            {    int u = Integer.parseInt(sc.next());
                 int v = Integer.parseInt(sc.next());
                 
                 // adding directed edgese between 
                 // vertex 'u' and 'v'
                 adj.get(u).add(v);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.kosaraju(V, adj));
		}
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    //Function to find number of strongly connected components in the graph.
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> graph)
    {
        //step 1
        boolean[] visited = new boolean[V];
        LinkedList<Integer> stack = new LinkedList<>();
        
        for(int i = 0; i < V; i++){
            if(visited[i] == false){
                dfs1(i, graph, stack, visited);
            }
        }
        
        //step 2
        //making new grpah and reversing edges
        
        ArrayList<ArrayList<Integer>> ngraph = new ArrayList<>();
        
        for(int i = 0; i < V; i++){
            ngraph.add(new ArrayList<>());
        }
        
        for(int i = 0; i < V; i++){
            for(int nbr : graph.get(i)){
                ngraph.get(nbr).add(i);
            }
        }
        
        //step 3
        visited = new boolean[V];
        int count = 0;
        while(stack.size() > 0){
            int rem = stack.removeFirst();
            
            if(visited[rem] == true) continue;
            
            dfs2(rem,ngraph,visited);
            count++;
        }
        
        return count;
    }
    
    public void dfs1(int src,ArrayList<ArrayList<Integer>> graph,LinkedList<Integer> stack, boolean[] visited){
        visited[src] = true;
        
        for(int nbr : graph.get(src)){
            if(visited[nbr] == false){
                dfs1(nbr, graph, stack, visited);
            }
        }
        
        stack.addFirst(src);
    }
    
    public void dfs2(int src,ArrayList<ArrayList<Integer>> graph, boolean[] visited){
        visited[src] = true;
        
        for(int nbr : graph.get(src)){
            if(visited[nbr] == false){
                dfs2(nbr, graph, visited);
            }
        }
    }
}
