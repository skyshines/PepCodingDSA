class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        TreeSet<Integer> ts = new TreeSet<>();
        
        for(int val : heaters) ts.add(val);
        
        
        int ans = -1;
        
        for(int house : houses){
            int hp = Integer.MAX_VALUE;
            Integer ceil = ts.ceiling(house);
            if(ceil != null) hp = (int)Math.min(hp,ceil - house);
            
            Integer floor = ts.floor(house);
            if(floor != null) hp = (int)Math.min(hp,house - floor);
            
            ans = (int)Math.max(ans,(int)Math.abs(hp));
        }
        return ans;
    }
}