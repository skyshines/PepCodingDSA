class Solution {
    public boolean canCross(int[] stones) {
        HashMap<Integer, HashSet<Integer>> hm = new HashMap<>();
        
        for(int val : stones){
            HashSet<Integer> hs = new HashSet<>();
            if(val == 0){
                hs.add(1);
            }
            hm.put(val,hs);
        }
        
        for(int val : stones){
            for(int jump : hm.get(val)){
                if(val + jump == stones[stones.length - 1]){
                    return true;
                }
                if(hm.containsKey(jump + val)){
                if(jump != 1) hm.get(val + jump).add(jump - 1);
                hm.get(val + jump).add(jump);
                hm.get(val + jump).add(jump + 1);
                }    
            }
        }
        
        
        return false;
        
    }
}