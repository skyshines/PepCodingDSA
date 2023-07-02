class Solution {
    public int manhattanDistance(int i, int j, int[][] points){
        int distX = Math.abs(points[i][0] - points[j][0]);
        int distY = Math.abs(points[i][1] - points[j][1]);
        
        return distX + distY;
    }
    
    int[] par;
    int[] rank;
    
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        int[][] edges = new int[n * (n - 1) / 2][3];
        
        int idx = 0;
        
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                int wt = manhattanDistance(i, j, points);
                
                edges[idx][0] = i;
                edges[idx][1] = j;
                edges[idx][2] = wt;
                
                idx++;
            }
        }
        
        Arrays.sort(edges, (a, b) -> (a[2] - b[2]));
	    
        int V = points.length;
        
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
    
    public int find(int x){
	    if(par[x] == x){
	        return x;
	    }
	    int temp = find(par[x]);
	    par[x] = temp;
	    
	    return temp;
	}
	
	public boolean union(int x, int y){
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