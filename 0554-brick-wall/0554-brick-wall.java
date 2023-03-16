class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        
        int max = 0;
        
        for(List<Integer> list : wall){
            int ps = 0;
            
            for(int i = 0; i < list.size() - 1; i++){
                ps += list.get(i);
                hm.put(ps,hm.getOrDefault(ps,0) + 1);
                max = hm.get(ps) > max ? hm.get(ps) : max;
            }
        }
        
        return wall.size() - max;
    }
}