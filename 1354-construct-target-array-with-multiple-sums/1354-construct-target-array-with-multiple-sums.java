class Solution {
    public boolean isPossible(int[] target) {
        PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());
        Long add = 0L;
        
        for(int val : target){
            pq.add(1L * val);
            add += val;
        }
        
        while(pq.peek() != 1){
            long max = pq.remove();
            long left = add - max;
            
            if((left > 0 && left < max) == false){
                return false;
            }
            
            long val = max % left;
            
            if(val == 0) pq.add(left);
            else pq.add(val);
            
            add = left + val;
        }
        
        return true;
    }
}