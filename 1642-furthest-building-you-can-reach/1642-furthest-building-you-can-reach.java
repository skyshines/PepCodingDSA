class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        //Min Heap
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        int i = 1;
        for(; i < heights.length; i++){
            if(heights[i] <= heights[i - 1]) continue;
            
            int inc = heights[i] - heights[i - 1];
            pq.add(inc);
            
            if(pq.size() > ladders){
                if(pq.peek() > bricks) return i - 1;
                else{
                    bricks = bricks - pq.poll();
                }
            }
        }
        
        return i - 1;
    }
}