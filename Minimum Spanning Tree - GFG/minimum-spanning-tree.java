//{ Driver Code Starts


import java.util.*;
import java.io.*;
import java.lang.*;

public class Main{
	static BufferedReader br;
	static PrintWriter ot;
    public static void main(String args[]) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		ot = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine().trim());
		while(t-- > 0){
			String s[] = br.readLine().trim().split(" ");
			int V = Integer.parseInt(s[0]);
			int E = Integer.parseInt(s[1]);
			int edges[][] = new int[E][3];
			for(int i = 0; i < E; i++){
				s = br.readLine().trim().split(" ");
				edges[i][0] = Integer.parseInt(s[0]);
				edges[i][1] = Integer.parseInt(s[1]);
				edges[i][2] = Integer.parseInt(s[2]);
			}
			ot.println(new Solution().spanningTree(V, E, edges));
		}
		ot.close();
	}
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static int[] par;
    static int[] rank;
    
	static int spanningTree(int V, int E, int edges[][]){
	    // Code Here.
	    Arrays.sort(edges, (a, b) -> (a[2] - b[2]));
	    
	    par = new int[V];
	    rank = new int[V];
	    
	    int ans = 0;
	    for(int i = 0; i < V; i++){
	        par[i] = i;
	        rank[i] = 1;
	    }
	    
	    for(int[] arr : edges){
	        boolean flag = union(arr[0], arr[1]);
	        if(flag == true){
	            ans += arr[2];
	        }
	    }
	    
	    return ans;
	}
	
	public static int find(int x){
	    if(par[x] == x){
	        return x;
	    }
	    int temp = find(par[x]);
	    par[x] = temp;
	    
	    return temp;
	}
	
	public static boolean union(int x, int y){
	    int leaderX = find(x);
	    int leaderY = find(y);
	    
	    if(leaderX != leaderY){
	        if(rank[leaderX] > rank[leaderY]){
	            par[leaderY] = leaderX;
	        }else if(rank[leaderX] < rank[leaderY]){
	            par[leaderX] = leaderY;
	        }else{
	            par[leaderX] = leaderY;
	            rank[leaderY]++;
	        }
	        
	        return true;
	    }else{
	        return false;
	    }
	}
}