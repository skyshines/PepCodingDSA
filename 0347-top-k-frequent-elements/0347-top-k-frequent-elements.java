class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        
        for(int num : nums){
            hm.put(num, hm.getOrDefault(num, 0) + 1);
        }
        
        //min order priority queue
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> (hm.get(a) - hm.get(b)));
        
        for(int num : hm.keySet()){
            pq.add(num);
            
            if(pq.size() > k) pq.poll();
        }
        
        int[] ans = new int[k];
        
        for(int i = 0; i < ans.length; i++){
            ans[i] = pq.poll();
        }
        
        return ans;
    }
}