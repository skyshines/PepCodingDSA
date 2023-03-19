class Solution {
    public void countSort(int[][] mat,int row, int col){
        int[] map = new int[101];
        
        int i = row, j = col; 
        
        while(i < mat.length && j < mat[0].length){
            map[mat[i][j]] += 1;
            i++;
            j++;
        }
        
        i = row; j = col;
        
        int k = 0;
        
        while(i < mat.length && j < mat[0].length){
            while(map[k] == 0){
                k++;
            }
            
            mat[i][j] = k;
            map[k]--;
            
            i++;
            j++;
        }
        
    }
    public int[][] diagonalSort(int[][] mat) {
        
        for(int j = 0; j < mat[0].length; j++){
            countSort(mat,0,j);
        }
        
        for(int i = 1; i < mat.length; i++){
            countSort(mat,i,0);
        }
        
        return mat;
    }
}