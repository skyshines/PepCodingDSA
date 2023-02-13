class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int tne = matrix.length * matrix[0].length;
        
        int count = 0;
        
        int maxrow = matrix.length - 1;
        int maxcol = matrix[0].length - 1;
        int minrow = 0;
        int mincol = 0;
        
        while(count < tne){
            //upper wall;
            
            for(int i = minrow, j = mincol; j <= maxcol && count < tne; j++){
                ans.add(matrix[i][j]);
                count++;
            }
            
            minrow++;
            
            
            //right wall
            
            for(int i = minrow, j = maxcol; i <= maxrow && count < tne; i++){
                ans.add(matrix[i][j]); count++;
            }
            
            maxcol--;
            
            //lower wall
            
            for(int i = maxrow, j = maxcol; j >= mincol && count < tne; j--){
                ans.add(matrix[i][j]); count++;
            }
            
            maxrow--;
            
            //left wall
            
            for(int i = maxrow, j = mincol; i >= minrow && count < tne; i--){
                ans.add(matrix[i][j]); count++;
            }
            
            mincol++;
            
        }
        
        return ans;
    }
}