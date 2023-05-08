class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //finding row
        
        int row = binarySearchRowSelect(matrix, target);
        
        if(row == -1) return false;
        
        return binarySearch(matrix, row, target);
    }
    
    public int binarySearchRowSelect(int[][] matrix, int target){
        int lo = 0;
        int hi = matrix.length - 1;
        int lc = matrix[0].length - 1;
        
        while(lo <= hi){
            int mid = lo + (hi - lo) / 2;
            
            if(matrix[mid][0] <= target && target <= matrix[mid][lc]){
                return mid;
            }else if(target < matrix[mid][0]){
                hi = mid - 1;
            }else{
                lo = mid + 1;
            }
        }
        
        return -1;
    }
    
    public boolean binarySearch(int[][] matrix,int row, int target){
        int lo = 0;
        int hi = matrix[0].length - 1;
        
        while(lo <= hi){
            int mid = lo + (hi - lo) / 2;
            
            if(matrix[row][mid] == target){
                return true;
            }else if(matrix[row][mid] < target){
                lo = mid + 1;
            }else{
                hi = mid - 1;
            }
        }
        
        return false;
    }
}