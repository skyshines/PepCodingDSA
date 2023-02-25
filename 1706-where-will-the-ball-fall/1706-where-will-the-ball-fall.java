class Solution {
    public int[] findBall(int[][] grid) {
        int[] ans = new int[grid[0].length];
        
        for(int b = 0; b < grid[0].length; b++){
            int currpos = b;
            int nextpos;
            
            for(int i = 0; i < grid.length; i++){
                nextpos = currpos + grid[i][currpos];
                
                
                if(nextpos < 0 || nextpos >= grid[0].length || grid[i][currpos] != grid[i][nextpos]){
                    currpos = -1;
                    break;
                }
                
                currpos = nextpos;
                
            }
            
            ans[b] = currpos;
        }
        
        return ans;
    }
}