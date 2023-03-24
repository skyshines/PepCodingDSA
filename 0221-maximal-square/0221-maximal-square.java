class Solution {
    public int maximalSquare(char[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        //max length of square keeping i,j as top left of the square
        
        int ms = 0;
        
        for(int i = matrix.length - 1; i >= 0; i--){
            for(int j = matrix[0].length - 1; j >= 0; j--){
                
                if(matrix[i][j] == '1'  && ms  == 0){
                    ms = 1;
                }
                //dividing 2d array into 4 parts
                
                if(i == matrix.length - 1 && j == matrix[0].length - 1){
                    dp[i][j] = matrix[i][j] - '0';
                }else if(i == matrix.length - 1){
                    dp[i][j] = matrix[i][j] - '0';
                }else if(j == matrix[0].length - 1){
                    dp[i][j] = matrix[i][j] - '0';
                }else{
                    if(matrix[i][j] == '1'){
                        int min = dp[i + 1][j];
                        
                        if(min > dp[i][j + 1]) min = dp[i][j + 1];
                        if(min > dp[i + 1][j + 1]) min = dp[i + 1][j + 1];
                        
                        dp[i][j] = min + 1;
                        
                        if(ms < dp[i][j]) ms = dp[i][j];
                    }else{
                        dp[i][j] = 0; 
                    }
                }
            }
        }
        
        return ms * ms;
    }
}