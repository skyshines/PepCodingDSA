class Solution {
    int[] parent;
    int[] rank;
    
    public int regionsBySlashes(String[] grid) {
        int dots = grid.length + 1;
        parent = new int[dots * dots];
        rank = new int[dots * dots];
        int count = 1;
        
        for(int i = 0; i < parent.length; i++){
            parent[i] = i;
            rank[i] = 1;
        }
        
        for(int i = 0; i < dots; i++){
            for(int j = 0; j < dots; j++){
                if(i == 0 || j == 0 || i == dots - 1 || j == dots - 1){
                    int cellno = i * dots + j;
                    
                    union(0, cellno);
                }
            }
        }
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length(); j++){
                char ch = grid[i].charAt(j);
                
                if(ch == '/'){
                    int cellno1 = i * dots + j + 1;
                    int cellno2 = (i + 1) * dots + j;
                    
                    if(union(cellno1, cellno2) == false){
                        count++;
                    }
                }else if(ch == '\\'){
                    int cellno1 = i * dots + j;
                    int cellno2 = (i + 1) * dots + (j + 1);
                    
                    if(union(cellno1, cellno2) == false){
                        count++;
                    }    
                }
            }
        }
        
        return count;
    }
    
    public int find(int x){
        if(x == parent[x]){
            return x;
        }
        
        int temp = find(parent[x]);
        parent[x] = temp;
        
        return temp;
    }
    
    public boolean union(int x, int y){
        int lx = find(x);
        int ly = find(y);
        
        if(lx == ly){
            return false;
        }else{
            if(rank[lx] > rank[ly]){
                parent[ly] = lx;
            }else if(rank[ly] > rank[lx]){
                parent[lx] = ly;
            }else{
                parent[lx] = ly;
                rank[ly]++;
            }   
            return true;
        }
    }
}