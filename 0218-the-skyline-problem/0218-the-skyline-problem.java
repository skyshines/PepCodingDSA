class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<Pair> list = new ArrayList<>();
        
        for(int[] building : buildings){
            int sp = building[0];
            int ep = building[1];
            int ht = building[2];
            
            list.add(new Pair(sp, -ht));
            list.add(new Pair(ep,  ht));
        }
        
        Collections.sort(list);
        List<List<Integer>> ans = new ArrayList<>();
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.add(0);
        
        int currht = 0;
        
        for(Pair p : list){
            if(p.ht < 0){
                pq.add(-p.ht);
            }else{
                pq.remove(p.ht);//pq c peek k alwa remove O(N) time leta hai
            }
            
            if(currht != pq.peek()){
                List<Integer> temp = new ArrayList<>();
                temp.add(p.x);
                temp.add(pq.peek());
                ans.add(temp);
            }
            
            currht = pq.peek();
        }
        
        return ans;
        
    }
    
    public class Pair implements Comparable<Pair>{
        int x;
        int ht;
        
        Pair(int x, int ht){
            this.x = x;
            this.ht = ht;
        }
        
        public int compareTo(Pair o){
            if(this.x == o.x){
                return this.ht - o.ht;
            }else{
                return this.x - o.x;
            }
        }
    }
}