class Solution {
    public class Pair implements Comparable<Pair>{
        int val;
        int gap;
        
        Pair(int val, int gap){
            this.val = val;
            this.gap = gap;
        }
        
        public int compareTo(Pair o){
            if(this.gap != o.gap){
                return this.gap - o.gap;
            }else{
                return this.val - o.val;
            }
        }
    }
    
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        ArrayList<Integer> ans = new ArrayList<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int val : arr){
            int gap = x - val;
            if(gap < 0) gap = -gap;
            
            if(pq.size() < k){
                pq.add(new Pair(val, gap));
            }else{
                if(pq.peek().gap > gap){
                    pq.remove();
                    pq.add(new Pair(val, gap));
                }
            }
        }
        
        while(pq.size() > 0){
            ans.add(pq.remove().val);
        }
        
        Collections.sort(ans);
        
        return ans;
    }
}