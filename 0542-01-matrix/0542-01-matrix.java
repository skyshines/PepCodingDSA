class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        //top to bootom
        
        int n = matrix.length;
        int m = matrix[0].length;
        
        if(matrix[0][0] == 1) matrix[0][0] = n + m;
        if(matrix[0][0] == 1) matrix[n - 1][m - 1] = n + m;
        
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(i == 0 && j == 0){
                    
                }else if(i == 0){
                    if(matrix[i][j] != 0){
                        matrix[i][j] = matrix[i][j - 1] + 1;
                    }
                }else if(j == 0){
                    if(matrix[i][j] != 0){
                        matrix[i][j] = matrix[i - 1][j] + 1;
                    }
                }else{
                    if(matrix[i][j] != 0){
                        matrix[i][j] = (int)Math.min(matrix[i - 1][j],matrix[i][j - 1]) + 1;
                    }
                }
            }
        }
        
        for(int i = matrix.length - 1; i >= 0 ; i--){
            for(int j = matrix[0].length - 1; j >= 0 ; j--){
                if(i == matrix.length - 1 && j == matrix[0].length - 1){
                    
                }else if(i == matrix.length - 1){
                    if(matrix[i][j] != 0){
                        matrix[i][j] = (int)Math.min(matrix[i][j + 1] + 1,matrix[i][j]);
                    }
                }else if(j == matrix[0].length - 1){
                    if(matrix[i][j] != 0){
                        matrix[i][j] = (int)Math.min(matrix[i + 1][j] + 1,matrix[i][j]);
                    }
                }else{
                    
                    if(matrix[i][j] != 0){
                        int temp = (int)Math.min(matrix[i + 1][j],matrix[i][j + 1]) + 1;
                        matrix[i][j] = (int)Math.min(temp,matrix[i][j]);
                    }
                }
            }
        }
        
        return matrix;
        
        
    }
}