class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //finding row
        
        int row = 0;
        
        int lo = 0;
        int hi = matrix.length - 1;
        
        while(lo <= hi){
            int mid = lo + (hi - lo) / 2;
            
            if(matrix[mid][0] == target){
                return true;
            }else if(matrix[mid][0] > target){
                hi = mid - 1;
            }else{
                row = mid;
                lo = mid + 1;
            }
        }
        
        lo = 0;
        hi = matrix[0].length - 1;
        
        while(lo <= hi){
            int mid = lo + (hi - lo) / 2;
            
            if(matrix[row][mid] == target){
                return true;
            }else if(matrix[row][mid] > target){
                hi = mid - 1;
            }else{
                lo = mid + 1;
            }
        }
        
        return false;
    }
}