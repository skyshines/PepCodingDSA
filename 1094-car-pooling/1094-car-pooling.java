class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int maxSl = -1;
        
        for(int[] trip : trips){
            if(trip[0] > capacity) return false;
            maxSl = (int)Math.max(trip[2],maxSl);
        }
        
        int[] highway = new int[maxSl + 1];
        
        for(int[] trip : trips){
            highway[trip[1]] += trip[0];
            highway[trip[2]] -= trip[0];
        }
        
        for(int i = 1; i < highway.length; i++){
            highway[i] += highway[i - 1];
            
            if(highway[i] > capacity) return false;
        }
        
        return true;
    }
}