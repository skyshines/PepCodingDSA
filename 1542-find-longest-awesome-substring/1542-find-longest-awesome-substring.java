class Solution {
    public int longestAwesome(String s) {
        Integer[] map = new Integer[(1 << 10)];
        //base case
        map[0] = -1;
        
        int ans = 0;
        
        int state = 0;
        
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            int mask = (1 << (ch - '0'));
            state ^= mask;
            
            Integer j = map[state];
            
            //for same
            if(j != null){
                ans = (int)Math.max(ans, i - j);
            }
            
            //for other bits
            
            for(int odd = 0; odd < 10; odd++){
                mask = (1 << (odd));
                int oddstate = (state ^ mask);
                j = map[oddstate];
                
                if(j != null){
                    ans = (int)Math.max(ans, i - j);
                }
            }
            
            if(map[state] == null){
                map[state] = i;
            }
        }
        
        return ans;
    }
}
/*
class Solution {
    public int longestAwesome(String s) {
        //using HashMap
        HashMap<Integer, Integer> hm = new HashMap<>();
        //base case
        hm.put(0, -1);
        
        int ans = 0;
        
        int state = 0;
        
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            int mask = (1 << (ch - '0'));
            state ^= mask;
            
            Integer j = hm.get(state);
            
            //for same
            if(j != null){
                ans = (int)Math.max(ans, i - j);
            }
            
            //for other bits
            
            for(int odd = 0; odd < 10; odd++){
                mask = (1 << (odd));
                int oddstate = (state ^ mask);
                j = hm.get(oddstate);
                
                if(j != null){
                    ans = (int)Math.max(ans, i - j);
                }
            }
            
            if(hm.containsKey(state) == false){
                hm.put(state, i);
            }
        }
        
        return ans;
    }
}

*/