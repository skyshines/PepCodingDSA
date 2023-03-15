class Solution {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        HashSet<Integer> hs = new HashSet<>();
        
        for(int i = 1; i < bound; i = i * x){
            
            for(int j = 1; j + i <= bound; j = j * y){
                hs.add(i + j);
                
                if(y == 1) break;
            }
            
            if(x == 1) break;
        }
        
        
        List<Integer> ans = new ArrayList<>(hs);
        return ans;
    }
}