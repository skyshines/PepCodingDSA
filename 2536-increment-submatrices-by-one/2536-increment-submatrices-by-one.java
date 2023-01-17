class Solution {
    
    public void fill(int[][] mat,int i1, int j1, int i2, int j2){
        
        
        if(i1 == i2 && j1 == j2){
            mat[i1][j1]++; return;
        }else if(i1 < i2 && j1 < j2){
            for(int j = j1; j <= j2; j++){
                mat[i1][j]++;
            }
            
            for(int i = i1 + 1; i <= i2; i++){
                mat[i][j1]++;
            }
            
            fill(mat,i1 + 1, j1 + 1,i2,j2);
        }else if(i1 == i2){
            for(int j = j1; j <= j2; j++){
                mat[i1][j]++;
            }
        }else{
            for(int i = i1; i <= i2; i++){
                mat[i][j1]++;
            }
        }
        
        
    }
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] mat = new int[n][n];
        
        for(int[] q : queries){
            fill(mat,q[0],q[1],q[2],q[3]);
        }
        
        return mat;
    }
}