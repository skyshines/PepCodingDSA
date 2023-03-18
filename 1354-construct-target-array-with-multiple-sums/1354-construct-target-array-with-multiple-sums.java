class Solution {
    public boolean isPossible(int[] target) {
        PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());
        Long sum = 0L;
        
        for(int val : target){
            pq.add(1L * val);
            sum += val;
        }
        
        while(pq.peek() != 1){
            long max = pq.remove();
            
            long leftSum = sum - max;
            
            if(leftSum <= 0 || leftSum >= max){
                return false;
            }
            
            long rem = max % leftSum;
            
            pq.add(rem == 0 ? leftSum : rem);
            
            sum += -max + (rem);
        }
        
        return true;
    }
}