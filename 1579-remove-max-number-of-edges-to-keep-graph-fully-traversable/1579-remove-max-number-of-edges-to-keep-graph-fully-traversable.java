class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        int[] parenta = new int[n + 1];
        int[] ranka = new int[n + 1];
        
        int[] parentb = new int[n + 1];
        int[] rankb = new int[n + 1];
        
        for(int i = 0; i < n; i++){
            parenta[i] = i;
            ranka[i] = 1;
            parentb[i] = i;
            rankb[i] = 1;
        }
        
        Arrays.sort(edges, (a, b) -> (b[0] - a[0]));
        
        int counta = 1;
        int countb = 1;
        
        int ans = 0;
        
        for(int[] edge : edges){
            if(edge[0] == 1){
                if(union(edge[1], edge[2],parenta,ranka) == true){
                    counta++;
                }else{
                    ans++;
                }
            }else if(edge[0] == 2){
                if(union(edge[1], edge[2],parentb,rankb) == true){
                    countb++;
                }else{
                    ans++;
                }
            }else{
                boolean flaga = false;
                boolean flagb = false;
                
                if(union(edge[1], edge[2],parenta,ranka) == true){
                    counta++;
                }else{
                    flaga = true;
                }
                if(union(edge[1], edge[2],parentb,rankb) == true){
                    countb++;
                }else{
                    flagb = true;
                }
                
                if(flaga == true && flagb == true){
                    ans++;
                }
            }
        }
        
        if(counta == n && countb == n){
            return ans;
        }else{
            return -1;
        }
    }
    
    public int find(int x, int[] parent){
        if(parent[x] == x){
            return x;
        }
        
        int temp = find(parent[x], parent);
        parent[x] = temp;
        return temp;
    }
    
    public boolean union(int x, int y,int[] parent,int[] rank){
        int lx = find(x, parent);
        int ly = find(y, parent);
        
        if(lx != ly){
            if(rank[lx] > rank[ly]){
                parent[ly] = lx;
            }else if(rank[ly] > rank[lx]){
                parent[lx] = ly;
            }else{
                parent[lx] = ly;
                rank[ly]++;
            }
            
            return true;
        }else{
            return false;
        }
    }
}