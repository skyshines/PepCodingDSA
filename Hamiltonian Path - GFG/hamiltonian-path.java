//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String input_line[] = read.readLine().trim().split("\\s+");
            int N = Integer.parseInt(input_line[0]);
            int M = Integer.parseInt(input_line[1]);
            
            input_line = read.readLine().trim().split("\\s+");
            ArrayList<ArrayList<Integer>> Edges = new ArrayList<ArrayList<Integer>>(); 
            for(int i = 0; i < M; i++){
                ArrayList<Integer> e = new ArrayList<Integer>();
                e.add(Integer.parseInt(input_line[2*i]));
                e.add(Integer.parseInt(input_line[2*i+1]));
                Edges.add(e);
            }
            Solution ob = new Solution();
            if(ob.check(N, M, Edges)){
                System.out.println(1);
            }
            else{
                System.out.println(0);
            }
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java
class Solution 
{   
    public class Edge{
        int src;
        int nbr;
        
        Edge(int src, int nbr){
            this.src = src;
            this.nbr = nbr;
        }
    }
    
    boolean check(int N, int M, ArrayList<ArrayList<Integer>> Edges)
    { 
        ArrayList<Edge>[] graph = new ArrayList[N];
        
        for(int i = 0; i < N; i++){
            graph[i] = new ArrayList<>();
        }
        
        for(ArrayList<Integer> e : Edges){
            int v1 = e.get(0) - 1;
            int v2 = e.get(1) - 1;
            graph[v1].add(new Edge(v1, v2));
            graph[v2].add(new Edge(v2, v1));
            //System.out.println(v1 + " " + v2);
        }
        
        
        
        HashSet<Integer> visited = new HashSet<>();
        
        boolean flag;
        for(int i = 0; i < N; i++){
           flag = hamiltonianPathExits(graph,i,visited);
           if(flag == true){
               return true;
           }
        }
        
        
        return false;
    }
    
    public boolean hamiltonianPathExits(ArrayList<Edge>[] graph,int src,HashSet<Integer> visited){
        if(visited.size() == graph.length - 1){
            return true;
        }
        
        boolean flag;
        
        visited.add(src);
        
        for(Edge edge : graph[src]){
            if(visited.contains(edge.nbr) == false){
                
                flag = hamiltonianPathExits(graph, edge.nbr, visited);
                
                if(flag == true){
                    return true;
                }
            }
        }
        
        visited.remove(src);
        
        return false;
        
    }
} 