class Solution {
    HashMap<Integer, Integer> hm;
    Random r;
    int top;
    
    public Solution(int n, int[] blacklist) {
        hm = new HashMap<>();
        r = new Random();
        top = n - blacklist.length;
        HashSet<Integer> hs = new HashSet<>();
        
        for(int val : blacklist){
            hs.add(val);
        }
        
        int ptr = n - 1;
        
        for(int val : blacklist){
            if(val < top){
                //we need to map this
                
                while(hs.contains(ptr)){
                    ptr--;
                }
                
                hm.put(val, ptr);
                ptr--;
            }
        }
        
    }
    
    public int pick() {
        int random = r.nextInt(top);
        if(hm.containsKey(random) == true){
            return hm.get(random);
        }
        
        return random;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(n, blacklist);
 * int param_1 = obj.pick();
 */